package com.cooksys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cooksys.entity.AppInterest;
import com.cooksys.service.InterestService;

@RestController
@RequestMapping("interests")
public class InterestController {

	@Autowired
	private InterestService intService;

	// GET /api/interests
	@RequestMapping(method = RequestMethod.GET)
	public List<AppInterest> allInterests() {
		return intService.getAll();
	}

	// POST /api/interests
	@RequestMapping(path = "/{name}", method = RequestMethod.POST)
	public AppInterest newInterest(@PathVariable("name") String name) {
		return intService.set(name);
	}

	// GET /api/interests/{id}
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public AppInterest getInterest(@PathVariable("id") long id) {
		return intService.get(id);
	}

	// PATCH /api/interests/{id}
	@RequestMapping(path = "/{id}/{newName}", method = RequestMethod.PATCH)
	public AppInterest updateInterest(@PathVariable("id") long id, @PathVariable("newName") String newName) {
		return intService.update(id, newName);
	}

	// DELETE /api/interests/{id}
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public String deleteState(@PathVariable("id") long id) {
		return intService.delete(id);
	}
}
