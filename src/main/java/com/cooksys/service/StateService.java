package com.cooksys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.AppCity;
import com.cooksys.entity.AppState;
import com.cooksys.repository.CityRepository;
import com.cooksys.repository.StateRepository;

@Service
public class StateService {

	@Autowired
	StateRepository stateRepo;

	@Autowired
	CityRepository cityRepo;

	// GET /api/states
	public List<AppState> getAll() {
		return stateRepo.findAll();
	}

	// POST /api/states
	public AppState set(String name) {
		return stateRepo.saveAndFlush(new AppState(name));
	}

	// GET /api/states/{id}
	public AppState get(long id) {
		return stateRepo.findOne(id);
	}

	// PATCH /api/states/{id}
	public AppState update(long id, String newName) {
		AppState state = stateRepo.findOne(id);
		state.setName(newName);
		return stateRepo.saveAndFlush(state);
	}

	// DELETE /api/states/{id}
	public String delete(long id) {
		for (AppCity city : cityRepo.findAllByState_id(id)) {
			city.setState(null);
			cityRepo.saveAndFlush(city);
		}
		stateRepo.delete(id);
		return "State with id: " + id + " was deleted!";
	}

}
