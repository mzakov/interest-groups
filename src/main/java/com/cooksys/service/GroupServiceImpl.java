package com.cooksys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.AppCity;
import com.cooksys.entity.AppGroup;
import com.cooksys.entity.AppInterest;
import com.cooksys.entity.AppPerson;
import com.cooksys.repository.GroupsRepository;
import com.cooksys.repository.PersonRepository;
import com.cooksys.service.interfaces.GroupService;

@Service
public class GroupServiceImpl implements GroupService {

	private final GroupsRepository groupRepo;
	
	private final PersonRepository pplRepo;

	@Autowired
	public GroupServiceImpl(GroupsRepository groupRepo, PersonRepository pplRepo) {
		super();
		this.groupRepo = groupRepo;
		this.pplRepo = pplRepo;
	}

	// GET /api/groups
	@Override
	public List<AppGroup> index() {
		return groupRepo.findAll();
	}

	// POST /api/groups
	@Override
	public AppGroup create(AppGroup group) {
	return groupRepo.save(group);
	}

	// GET /api/groups/{id}
	@Override
	public AppGroup read(long id) {
		return groupRepo.findOne(id);
	}

	// PATCH /api/groups/{id}
	@Override
	public AppGroup update(long id, AppGroup groupToUpdate) {
		groupToUpdate.setId(id);
		return groupRepo.save(groupToUpdate);
	}

	// DELETE /api/groups/{id}
	@Override
	public AppGroup delete(long id) {
		AppGroup result = this.read(id);
		groupRepo.delete(id);
		return result;
	}

	// GET /api/groups/{id}/city
	@Override
	public AppCity readCity(long id) {
		AppCity city = this.read(id).getCity();
		return city;
	}

	// PUT /api/groups/{id}/city
	@Override
	public AppGroup updateCity(long id, AppCity cityToPut) {
		AppGroup result = this.read(id);
		result.setCity(cityToPut);
		return groupRepo.save(result);
	}

	// GET /api/groups/{id}/interest
	@Override
	public AppInterest readInterest(long id) {
		AppInterest interest = this.read(id).getInterest();
		return interest;
	}

	// PUT /api/groups/{id}/interest
	@Override
	public AppGroup updateInterest(long id, AppInterest interestToPut) {
		AppGroup result = this.read(id);
		result.setInterest(interestToPut);
		return groupRepo.save(result);
	}

	// GET /api/groups/{id}/members
	@Override
	public List<AppPerson> indexPeople(long id) {
		return this.read(id).getMembers();
	}

	// PUT /api/groups/{id}/members
	@Override
	public AppGroup updateMembers(long id, AppPerson personToAdd) {
		AppGroup result = this.read(id);
		result.getMembers().add(personToAdd);
		return groupRepo.save(result);
	}
	
// MAGIC AT WORK!!! TO BE TESTED!!!
	// DELETE /api/groups/{id}/members/{id}
	@Override
	public AppGroup deleteMember(long id, long member_id) {
		pplRepo.findOne(member_id).getGroups().remove(this.read(id));
		return groupRepo.findOne(id);
	}
}
