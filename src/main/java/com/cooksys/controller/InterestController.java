package com.cooksys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cooksys.entity.AppInterest;
import com.cooksys.service.interfaces.InterestService;

@RestController
@RequestMapping("interests")
public class InterestController {

	private final InterestService intService;
	
	@Autowired
	public InterestController(InterestService intService) {
		super();
		this.intService = intService;
	}

	// GET /api/interests
	@RequestMapping(method = RequestMethod.GET)
	public List<AppInterest> index() {
		return intService.index();
	}

	// POST /api/interests
	@RequestMapping(method = RequestMethod.POST)
	public AppInterest create(@RequestBody AppInterest interest) {
		return intService.create(interest);
	}

	// GET /api/interests/{id}
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public AppInterest read(@PathVariable("id") long id) {
		return intService.read(id);
	}

	// PATCH /api/interests/{id}
	@RequestMapping(value = "{id}", method = RequestMethod.PATCH)
	public AppInterest update(@PathVariable("id") long id, @RequestBody AppInterest interestToUpdate) {
		return intService.update(id, interestToUpdate);
	}

	// DELETE /api/interests/{id}
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public AppInterest delete(@PathVariable("id") long id) {
		return intService.delete(id);
	}
}
