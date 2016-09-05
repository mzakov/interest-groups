package com.cooksys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cooksys.entity.AppCity;
import com.cooksys.entity.AppGroup;
import com.cooksys.entity.AppInterest;
import com.cooksys.entity.AppPerson;
import com.cooksys.model.GetAllPeopleResponse;
import com.cooksys.service.PersonService;

@RestController
@RequestMapping("people")
public class PersonController {

	@Autowired
	private PersonService personService;

	// GET /api/people
	@RequestMapping(method = RequestMethod.GET)
	public List<GetAllPeopleResponse> allPeople() {
		return personService.getAll();
	}

	// POST /api/people
	@RequestMapping(path = "/{name},{city_id}", method = RequestMethod.POST)
	public AppPerson newPerson(@PathVariable("name") String name, @PathVariable("city_id") long city_id) {
		return personService.set(name, city_id);
	}

	// GET /api/people/{id}
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public AppPerson getPerson(@PathVariable("id") long id) {
		return personService.get(id);
	}

	// PATCH /api/people/{id}
	@RequestMapping(path = "/{id}/{newName}", method = RequestMethod.PATCH)
	public AppPerson updatePerson(@PathVariable("id") long id, @PathVariable("newName") String newName) {
		return personService.update(id, newName);
	}

	// DELETE /api/people/{id}
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public String deletePerson(@PathVariable("id") long id) {
		return personService.delete(id);
	}

	// GET /api/people/{id}/city
	@RequestMapping(path = "/{id}/city", method = RequestMethod.GET)
	public AppCity getCity(@PathVariable("id") long id) {
		return personService.getCity(id);
	}

	// PUT /api/people/{id}/city
	@RequestMapping(path = "/{id}/city/{city_id}", method = RequestMethod.PUT)
	public AppPerson putCity(@PathVariable("id") long id, @PathVariable("city_id") long city_id) {
		return personService.putCity(id, city_id);
	}

	// GET /api/people/{id}/interests
	@RequestMapping(path = "/{id}/interests", method = RequestMethod.GET)
	public List<AppInterest> allInterests(@PathVariable("id") long id) {
		return personService.getAllInterests(id);
	}

	// PUT /api/people/{id}/interests
	@RequestMapping(path = "/{id}/interests/{interest_id}", method = RequestMethod.PUT)
	public AppPerson putInterest(@PathVariable("id") long id, @PathVariable("interest_id") long interest_id) {
		return personService.putInterest(id, interest_id);
	}

	// DELETE /api/people/{id}/interests/{id}
	@RequestMapping(path = "/{id}/interests/{interest_id}", method = RequestMethod.DELETE)
	public AppPerson deleteInterest(@PathVariable("id") long id, @PathVariable("interest_id") long interest_id) {
		return personService.deleteInterest(id, interest_id);
	}

	// GET /api/people/{id}/groups
	@RequestMapping(path = "/{id}/groups", method = RequestMethod.GET)
	public List<AppGroup> allGroups(@PathVariable("id") long id) {
		return personService.getAllGroups(id);
	}

	// PUT /api/people/{id}/groups
	@RequestMapping(path = "/{id}/groups/{group_id}", method = RequestMethod.PUT)
	public AppPerson putGroup(@PathVariable("id") long id, @PathVariable("group_id") long group_id) {
		return personService.putGroup(id, group_id);
	}

	// DELETE /api/people/{id}/groups/{id}
	@RequestMapping(path = "/{id}/groups/{group_id}", method = RequestMethod.DELETE)
	public AppPerson deleteGroup(@PathVariable("id") long id, @PathVariable("group_id") long group_id) {
		return personService.deleteGroup(id, group_id);
	}
}
