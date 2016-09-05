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
public class GroupService {

	@Autowired
	GroupsRepository groupRepo;

	@Autowired
	CityRepository cityRepo;

	@Autowired
	InterestsRepository interestsRepo;

	@Autowired
	PersonRepository pplRepo;

	// GET /api/groups
	public List<AppGroup> getAll() {
		return groupRepo.findAll();
	}

	// POST /api/groups
	public AppGroup set(String name, long city_id, long interest_id) {
		AppCity city = cityRepo.findOne(city_id);
		AppInterest interest = interestsRepo.findOne(interest_id);
		return groupRepo.saveAndFlush(new AppGroup(name, city, interest));
	}

	// GET /api/groups/{id}
	public AppGroup get(long id) {
		return groupRepo.findOne(id);
	}

	// PATCH /api/groups/{id}
	public AppGroup update(long id, String newName) {
		AppGroup group = groupRepo.findOne(id);
		group.setName(newName);
		return groupRepo.saveAndFlush(group);
	}

	// DELETE /api/groups/{id}
	public String delete(long id) {
		AppGroup group = groupRepo.findOne(id);
		for (AppPerson member : group.getMembers()) {
			member.removeGroup(group);
			pplRepo.saveAndFlush(member);
		}
		group.setInterest(null);
		group.setCity(null);
		groupRepo.delete(id);
		return "Person with id: " + id + " was deleted!";
	}

	// GET /api/groups/{id}/city
	public AppCity getCity(long id) {
		AppGroup group = groupRepo.findOne(id);
		return group.getCity();
	}

	// PUT /api/groups/{id}/city
	public AppGroup putCity(long id, long city_id) {
		AppGroup group = groupRepo.findOne(id);
		group.setCity(cityRepo.findOne(city_id));
		return groupRepo.saveAndFlush(group);
	}

	// GET /api/groups/{id}/interest
	public AppInterest getInterest(long id) {
		AppGroup group = groupRepo.findOne(id);
		return group.getInterest();
	}

	// PUT /api/groups/{id}/interest
	public AppGroup putInterest(long id, long interest_id) {
		AppGroup group = groupRepo.findOne(id);
		AppInterest interest = interestsRepo.findOne(interest_id);
		group.setInterest(interest);
		return groupRepo.saveAndFlush(group);
	}

	// GET /api/groups/{id}/members
	public List<GetAllPeopleResponse> getAllMembers(long id) {
		return GetAllPeopleResponse.list(pplRepo.findAllByGroups_id(id));
	}

	// PUT /api/groups/{id}/members
	public List<GetAllPeopleResponse> putMember(long id, long member_id) {
		AppPerson person = pplRepo.findOne(member_id);
		AppGroup group = groupRepo.findOne(id);
		if (person.getCity().equals(group.getCity()) && person.getInterests().contains(group.getInterest())) {
			List<AppGroup> ints = person.getGroups();
			ints.add(group);
			person.setGroups(ints);
			pplRepo.saveAndFlush(person);
		}
		return GetAllPeopleResponse.list(pplRepo.findAllByGroups_id(id));
	}

	// DELETE /api/groups/{id}/members/{id}
	public AppGroup deleteMember(long id, long member_id) {
		AppGroup group = groupRepo.findOne(id);
		group.removeMember(pplRepo.findOne(member_id));
		return groupRepo.saveAndFlush(group);
	}
}
