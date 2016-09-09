package com.cooksys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.AppState;
import com.cooksys.repository.CityRepository;
import com.cooksys.repository.StateRepository;
import com.cooksys.service.interfaces.StateService;

@Service
public class StateServiceImpl implements StateService {

	@Autowired
	StateRepository stateRepo;

	@Autowired
	CityRepository cityRepo;

	// GET /api/states
	public List<AppState> index() {
		return stateRepo.findAll();
	}

	// POST /api/states
	public AppState create(AppState state) {
		return stateRepo.save(state);
	}

	// GET /api/states/{id}
	public AppState read(long id) {
		return stateRepo.findOne(id);
	}

	// PATCH /api/states/{id}
	public AppState update(long id, AppState stateToUpdate) {
		stateToUpdate.setId(id);
		return stateRepo.save(stateToUpdate);
	}

	// DELETE /api/states/{id}
	public AppState delete(long id) {
		AppState result = this.read(id);
		cityRepo.delete(id);
		return result;
	}
}
