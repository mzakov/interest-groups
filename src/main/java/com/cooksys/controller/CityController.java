package com.cooksys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cooksys.entity.AppCity;
import com.cooksys.entity.AppState;
import com.cooksys.service.CityService;

@RestController
@RequestMapping("cities")
public class CityController {

	@Autowired
	private CityService cityService;

	// GET /api/cities
	@RequestMapping(method = RequestMethod.GET)
	public List<AppCity> allCities() {
		return cityService.getAll();
	}

	// POST /api/cities
	@RequestMapping(path = "/{name},{state_id}", method = RequestMethod.POST)
	public AppCity newCity(@PathVariable("name") String name, @PathVariable("state_id") long state_id) {
		return cityService.set(name, state_id);
	}

	// GET /api/cities/{id}
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public AppCity getCity(@PathVariable("id") long id) {
		return cityService.get(id);
	}

	// PATCH /api/cities/{id}
	@RequestMapping(path = "/{id}/{newName}", method = RequestMethod.PATCH)
	public AppCity updateCity(@PathVariable("id") long id, @PathVariable("newName") String newName) {
		return cityService.update(id, newName);
	}

	// DELETE /api/cities/{id}
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public String deleteCity(@PathVariable("id") long id) {
		return cityService.delete(id);
	}

	// GET /api/cities/{id}/state
	@RequestMapping(path = "/{id}/state", method = RequestMethod.GET)
	public AppState getState(@PathVariable("id") long id) {
		return cityService.getState(id);
	}

	// PUT /api/cities/{id}/state
	@RequestMapping(path = "/{id}/state/{state_id}", method = RequestMethod.PUT)
	public AppCity putState(@PathVariable("id") long id, @PathVariable("state_id") long state_id) {
		return cityService.putState(id, state_id);
	}
}
