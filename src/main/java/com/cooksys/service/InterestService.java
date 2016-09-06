package com.cooksys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.AppGroup;
import com.cooksys.entity.AppInterest;
import com.cooksys.entity.AppPerson;
import com.cooksys.repository.GroupsRepository;
import com.cooksys.repository.InterestsRepository;
import com.cooksys.repository.PersonRepository;

@Service
public class InterestService {

	@Autowired
	InterestsRepository intRepo;

	@Autowired
	GroupsRepository groupRepo;

	@Autowired
	PersonRepository pplRepo;

	// GET /api/interests
	public List<AppInterest> getAll() {
		return intRepo.findAll();
	}

	// POST /api/interests
	public AppInterest set(String name) {
		return intRepo.saveAndFlush(new AppInterest(name));
	}

	// GET /api/interests/{id}
	public AppInterest get(long id) {
		return intRepo.findOne(id);
	}

	// PATCH /api/interests/{id}
	public AppInterest update(long id, String newName) {
		AppInterest interest = intRepo.findOne(id);
		interest.setName(newName);
		return intRepo.saveAndFlush(interest);
	}

	// DELETE /api/interests/{id}
	public String delete(long id) {
		AppInterest intr = intRepo.findOne(id);
		
		//This is where the magic happens!
		for (AppGroup group : groupRepo.findAllByInterest_id(id)) {
			group.setInterest(null);
		};
		for (AppPerson member : pplRepo.findAllByInterests_id(id)) {
			member.removeInterest(intr);
		}
		
		intRepo.delete(id);
		return "State with id: " + id + " was deleted!";
	}

}
