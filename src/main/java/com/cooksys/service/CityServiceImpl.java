package com.cooksys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.AppCity;
import com.cooksys.entity.AppState;
import com.cooksys.repository.CityRepository;
import com.cooksys.service.interfaces.CityService;

@Service
public class CityServiceImpl implements CityService {

	private final CityRepository cityRepo;
	
	@Autowired
	public CityServiceImpl(CityRepository cityRepo) {
		super();
		this.cityRepo = cityRepo;
	}

	// GET /api/cities
	@Override
	public List<AppCity> index() {
		return cityRepo.findAll();
	}

	// POST /api/cities
	@Override
	public AppCity create(AppCity city) {
	return cityRepo.save(city);
	}

	// GET /api/cities/{id}
	@Override
	public AppCity read(long id) {
		return cityRepo.findOne(id);
	}

	// PATCH /api/cities/{id}
	@Override
	public AppCity update(long id, AppCity cityToUpdate) {
		cityToUpdate.setId(id);
		return cityRepo.save(cityToUpdate);
	}

	// DELETE /api/cities/{id}
	@Override
	public AppCity delete(long id) {
		AppCity result = this.read(id);
		cityRepo.delete(id);
		return result;
	}

	// GET /api/cities/{id}/state
	@Override
	public AppState readState(long id) {
		AppState state = this.read(id).getState();
		return state;
	}

	// PUT /api/cities/{id}/state
	@Override
	public AppCity updateState(long id, AppState stateToPut) {
		AppCity result = this.read(id);
		result.setState(stateToPut);
		return result;
	}
}
