package com.cooksys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cooksys.entity.AppCity;
import com.cooksys.entity.AppState;
import com.cooksys.service.interfaces.CityService;

@RestController
@RequestMapping("cities")
public class CityController {

	private final CityService cityService;
	
	@Autowired
	public CityController(CityService cityService) {
		super();
		this.cityService = cityService;
	}

	// GET /api/cities
	@RequestMapping(method = RequestMethod.GET)
	public List<AppCity> index() {
		return cityService.index();
	}

	// POST /api/cities
	@RequestMapping(method = RequestMethod.POST)
	public AppCity create(@RequestBody AppCity city) {
		return cityService.create(city);
	}

	// GET /api/cities/{id}
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public AppCity read(@PathVariable("id") long id) {
		return cityService.read(id);
	}

	// PATCH /api/cities/{id}
	@RequestMapping(value = "{id}", method = RequestMethod.PATCH)
	public AppCity update(@PathVariable("id") long id, @RequestBody AppCity cityToUpdate) {
		return cityService.update(id, cityToUpdate);
	}

	// DELETE /api/cities/{id}
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public AppCity delete(@PathVariable("id") long id) {
		return cityService.delete(id);
	}

	// GET /api/cities/{id}/state
	@RequestMapping(path = "/{id}/state", method = RequestMethod.GET)
	public AppState readState(@PathVariable("id") long id) {
		return cityService.readState(id);
	}

	// PUT /api/cities/{id}/state
	@RequestMapping(path = "/{id}/state", method = RequestMethod.PUT)
	public AppCity putState(@PathVariable("id") long id, @RequestBody AppState stateToPut) {
		return cityService.updateState(id, stateToPut);
	}
}
