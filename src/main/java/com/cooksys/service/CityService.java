package com.cooksys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.AppCity;
import com.cooksys.entity.AppGroup;
import com.cooksys.entity.AppPerson;
import com.cooksys.entity.AppState;
import com.cooksys.repository.CityRepository;
import com.cooksys.repository.GroupsRepository;
import com.cooksys.repository.PersonRepository;
import com.cooksys.repository.StateRepository;

@Service
public class CityService {

	@Autowired
	CityRepository cityRepo;

	@Autowired
	StateRepository stateRepo;

	@Autowired
	GroupsRepository groupRepo;

	@Autowired
	PersonRepository pplRepo;

	// GET /api/cities
	public List<AppCity> getAll() {
		return cityRepo.findAll();
	}

	// POST /api/cities
	public AppCity set(String name, long state_id) {
		AppState state = stateRepo.findOne(state_id);
		return cityRepo.saveAndFlush(new AppCity(name, state));
	}

	// GET /api/cities/{id}
	public AppCity get(long id) {
		return cityRepo.findOne(id);
	}

	// PATCH /api/cities/{id}
	public AppCity update(long id, String newName) {
		AppCity city = cityRepo.findOne(id);
		city.setName(newName);
		return cityRepo.saveAndFlush(city);
	}

	// DELETE /api/cities/{id}
	public String delete(long id) {
		for (AppGroup group : groupRepo.findAllByCity_id(id)) {
			group.setCity(null);
			groupRepo.saveAndFlush(group);
		}
		;
		for (AppPerson person : pplRepo.findAllByCity_id(id)) {
			person.setCity(null);
			pplRepo.saveAndFlush(person);
		}
		cityRepo.delete(id);
		return "State with id: " + id + " was deleted!";
	}

	// GET /api/cities/{id}/state
	public AppState getState(long id) {
		AppCity city = cityRepo.findOne(id);
		return city.getState();
	}

	// PUT /api/cities/{id}/state
	public AppCity putState(long id, long state_id) {
		AppCity city = cityRepo.findOne(id);
		city.setState(stateRepo.findOne(state_id));
		return cityRepo.saveAndFlush(city);
	}
}
