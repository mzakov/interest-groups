package com.cooksys.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cooksys.entity.AppCity;
import com.cooksys.entity.AppGroup;
import com.cooksys.entity.AppInterest;
import com.cooksys.entity.AppPerson;
import com.cooksys.service.interfaces.PersonService;

@RestController
@RequestMapping("people")
public class PersonController {

	private final PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		super();
		this.personService = personService;
	}
	
	// GET /api/people
	@RequestMapping(method = RequestMethod.GET)
	public List<AppPerson> index() {
		return personService.index();
	}

	// POST /api/people
	@RequestMapping(method = RequestMethod.POST)
	public AppPerson create(@RequestBody AppPerson person) {
		return personService.create(person);
	}

	// GET /api/people/{id}
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public AppPerson read(@PathVariable("id") long id) {
		return personService.read(id);
	}

	// PATCH /api/people/{id}
	@RequestMapping(value = "{id}", method = RequestMethod.PATCH)
	public AppPerson update(@PathVariable("id") long id, @RequestBody AppPerson personToUpdate) {
		return personService.update(id, personToUpdate);
	}

	// DELETE /api/people/{id}
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public AppPerson delete(@PathVariable("id") long id) {
		return personService.delete(id);
	}

	// GET /api/people/{id}/city
	@RequestMapping(path = "/{id}/city", method = RequestMethod.GET)
	public AppCity readCity(@PathVariable("id") long id) {
		return personService.readCity(id);
	}

	// PUT /api/people/{id}/city
	@RequestMapping(path = "/{id}/city", method = RequestMethod.PUT)
	public AppPerson updateCity(@PathVariable("id") long id, @RequestBody AppCity cityToPut) {
		return personService.updateCity(id, cityToPut);
	}

	// GET /api/people/{id}/interests
	@RequestMapping(path = "/{id}/interests", method = RequestMethod.GET)
	public Set<AppInterest> indexInterests(@PathVariable("id") long id) {
		return personService.indexInterests(id);
	}

	// PUT /api/people/{id}/interests
	@RequestMapping(path = "/{id}/interests", method = RequestMethod.PUT)
	public AppPerson updateInterests(@PathVariable("id") long id, @RequestBody AppInterest interestToAdd) {
		return personService.updateInterests(id, interestToAdd);
	}

	// DELETE /api/people/{id}/interests/{id}
	@RequestMapping(path = "/{id}/interests/{interest_id}", method = RequestMethod.DELETE)
	public AppPerson deleteInterest(@PathVariable("id") long id, @PathVariable("interest_id") long interest_id) {
		return personService.deleteInterest(id, interest_id);
	}

	// GET /api/people/{id}/groups
	@RequestMapping(path = "/{id}/groups", method = RequestMethod.GET)
	public Set<AppGroup> indexGroups(@PathVariable("id") long id) {
		return personService.indexGroups(id);
	}

	// PUT /api/people/{id}/groups
	@RequestMapping(path = "/{id}/groups", method = RequestMethod.PUT)
	public AppPerson updateGroups(@PathVariable("id") long id, @RequestBody AppGroup groupToAdd) {
		return personService.updateGroups(id, groupToAdd);
	}

	// DELETE /api/people/{id}/groups/{id}
	@RequestMapping(path = "/{id}/groups/{group_id}", method = RequestMethod.DELETE)
	public AppPerson deleteGroup(@PathVariable("id") long id, @PathVariable("group_id") long group_id) {
		return personService.deleteGroup(id, group_id);
	}
}
