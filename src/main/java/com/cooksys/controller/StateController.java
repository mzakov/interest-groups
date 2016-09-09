package com.cooksys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cooksys.entity.AppState;
import com.cooksys.service.interfaces.StateService;

@RestController
@RequestMapping("states")
public class StateController {

	
	private final StateService stateService;

	@Autowired
	public StateController (StateService stateService) {
		super();
		this.stateService = stateService;
	}
	
	// GET /api/states
	@RequestMapping(method = RequestMethod.GET)
	public List<AppState> index() {
		return stateService.index();
	}

	// POST /api/states
	@RequestMapping(method = RequestMethod.POST)
	public AppState create(@RequestBody AppState state) {
		return stateService.create(state);
	}

	// GET /api/states/{id}
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public AppState read(@PathVariable("id") long id) {
		return stateService.read(id);
	}

	// PATCH /api/states/{id}
	@RequestMapping(value = "{id}", method = RequestMethod.PATCH)
	public AppState update(@PathVariable("id") long id, @RequestBody AppState stateToUpdate) {
		return stateService.update(id, stateToUpdate);
	}

	// DELETE /api/state/{id}
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public AppState delete(@PathVariable("id") long id) {
		return stateService.delete(id);
	}
}
