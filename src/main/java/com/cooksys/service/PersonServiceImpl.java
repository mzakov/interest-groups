package com.cooksys.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.AppCity;
import com.cooksys.entity.AppGroup;
import com.cooksys.entity.AppInterest;
import com.cooksys.entity.AppPerson;
import com.cooksys.repository.GroupsRepository;
import com.cooksys.repository.InterestsRepository;
import com.cooksys.repository.PersonRepository;
import com.cooksys.service.interfaces.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	private final PersonRepository pplRepo;
	private final InterestsRepository interestsRepo;
	private final GroupsRepository groupsRepo;
	
	@Autowired
	public PersonServiceImpl(PersonRepository pplRepo, InterestsRepository interestsRepo, GroupsRepository groupsRepo) {
		super();
		this.pplRepo = pplRepo;
		this.interestsRepo = interestsRepo;
		this.groupsRepo = groupsRepo;
	}

	// GET /api/people
	public List<AppPerson> index() {
		return pplRepo.findAll();
	}

	// POST /api/people
	public AppPerson create(AppPerson person) {
		return pplRepo.save(person);
	}

	// GET /api/people/{id}
	public AppPerson read(long id) {
		return pplRepo.findOne(id);
	}

	// PATCH /api/people/{id}
	public AppPerson update(long id, AppPerson personToUpdate) {
		personToUpdate.setId(id);
		return pplRepo.save(personToUpdate);
	}

	// DELETE /api/people/{id}
	public AppPerson delete(long id) {
		AppPerson result = this.read(id);
		pplRepo.delete(id);
		return result;
	}

	// GET /api/people/{id}/city
	public AppCity readCity(long id) {
		AppCity city = this.read(id).getCity();
		return city;
	}

	// PUT /api/people/{id}/city
	public AppPerson updateCity(long id, AppCity cityToPut) {
		AppPerson result = this.read(id);
		result.setCity(cityToPut);
		return pplRepo.save(result);
	}

	// GET /api/people/{id}/interests
	public Set<AppInterest> indexInterests(long id) {
		return this.read(id).getInterests();
	}

	// PUT /api/people/{id}/interests
	public AppPerson updateInterests(long id, AppInterest interestToAdd){
		AppPerson result = this.read(id);
		result.getInterests().add(interestToAdd);
		return pplRepo.save(result);
	}

	// DELETE /api/people/{id}/interests/{id}
	public AppPerson deleteInterest(long id, long interest_id) {
		AppPerson person = this.read(id);
		person.getInterests().remove(interestsRepo.findOne(interest_id));
		return pplRepo.saveAndFlush(person);
	}

	// GET /api/people/{id}/groups
	public Set<AppGroup> indexGroups(long id) {
		return this.read(id).getGroups();
	}

	// PUT /api/people/{id}/groups
	public AppPerson updateGroups(long id, AppGroup groupToAdd) {
		AppPerson result = this.read(id);
		result.getGroups().add(groupToAdd);
		return pplRepo.save(result);
	}

	// DELETE /api/people/{id}/groups/{id}
	public AppPerson deleteGroup(long id, long group_id) {
		AppPerson person = this.read(id);
		person.getGroups().remove(groupsRepo.findOne(group_id));
		return pplRepo.saveAndFlush(person);
	}
}
