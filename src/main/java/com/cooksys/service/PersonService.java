package com.cooksys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.AppCity;
import com.cooksys.entity.AppGroup;
import com.cooksys.entity.AppInterest;
import com.cooksys.entity.AppPerson;
import com.cooksys.model.GetAllPeopleResponse;
import com.cooksys.repository.CityRepository;
import com.cooksys.repository.GroupsRepository;
import com.cooksys.repository.InterestsRepository;
import com.cooksys.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository repo;

	@Autowired
	CityRepository cityRepo;

	@Autowired
	InterestsRepository interestsRepo;

	@Autowired
	GroupsRepository groupsRepo;

	// GET /api/people
	public List<GetAllPeopleResponse> getAll() {
		return GetAllPeopleResponse.list(repo.findAll());
	}

	// POST /api/people
	public AppPerson set(String name, long city_id) {
		AppCity city = cityRepo.findOne(city_id);
		return repo.saveAndFlush(new AppPerson(name, city));
	}

	// GET /api/people/{id}
	public AppPerson get(long id) {
		return repo.findOne(id);
	}

	// PATCH /api/people/{id}
	public AppPerson update(long id, String newName) {
		AppPerson person = repo.findOne(id);
		person.setName(newName);
		return repo.saveAndFlush(person);
	}

	// DELETE /api/people/{id}
	public String delete(long id) {
		repo.delete(id);
		return "Person with id: " + id + " was deleted!";
	}

	// GET /api/people/{id}/city
	public AppCity getCity(long id) {
		AppPerson person = repo.findOne(id);
		return person.getCity();
	}

	// PUT /api/people/{id}/city
	public AppPerson putCity(long id, long city_id) {
		AppPerson person = repo.findOne(id);
		person.setCity(cityRepo.findOne(city_id));
		return repo.saveAndFlush(person);
	}

	// GET /api/people/{id}/interests
	public List<AppInterest> getAllInterests(long id) {
		return interestsRepo.findAllByPeople_id(id);
	}

	// PUT /api/people/{id}/interests
	public AppPerson putInterest(long id, long interest_id) {
		AppPerson person = repo.findOne(id);
		List<AppInterest> ints = person.getInterests();
		ints.add(interestsRepo.findOne(interest_id));
		person.setInterests(ints);
		return repo.saveAndFlush(person);
	}

	// DELETE /api/people/{id}/interests/{id}
	public AppPerson deleteInterest(long id, long interest_id) {
		AppPerson person = repo.findOne(id);
		person.removeInterest(interestsRepo.findOne(interest_id));
		return repo.saveAndFlush(person);
	}

	// GET /api/people/{id}/groups
	public List<AppGroup> getAllGroups(long id) {
		return groupsRepo.findAllByMembers_id(id);
	}

	// PUT /api/people/{id}/groups
	public AppPerson putGroup(long id, long group_id) {
		AppPerson person = repo.findOne(id);
		AppGroup group = groupsRepo.findOne(group_id);
		if (person.getCity().equals(group.getCity()) && person.getInterests().contains(group.getInterest())) {
			List<AppGroup> ints = person.getGroups();
			ints.add(group);
			person.setGroups(ints);
			return repo.saveAndFlush(person);
		}
		return person;
	}

	// DELETE /api/people/{id}/groups/{id}
	public AppPerson deleteGroup(long id, long group_id) {
		AppPerson person = repo.findOne(id);
		person.removeGroup(groupsRepo.findOne(group_id));
		return repo.saveAndFlush(person);
	}
}
