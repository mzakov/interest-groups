package com.cooksys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cooksys.entity.AppPerson;
import com.cooksys.model.GetAllPeopleResponse;
import com.cooksys.service.PersonService;

@RestController
@RequestMapping("people")
public class PersonController {
	
	@Autowired
	private PersonService personService;

	@RequestMapping(method=RequestMethod.GET)
	public List<GetAllPeopleResponse> allPeople() {
		return personService.getAll();
	}
	
	@RequestMapping(path="/{name},{city_id}", method=RequestMethod.POST)
	public AppPerson newPerson(@PathVariable("name") String name, @PathVariable("city_id") long city_id) {
		return personService.set(name, city_id);
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public AppPerson person(@PathVariable("id") long id) {
		return personService.get(id);
	}
	
	@RequestMapping(path="/{id}/{newName}", method=RequestMethod.PATCH)
	public AppPerson updatePerson(@PathVariable("id") long id, @PathVariable("newName") String newName) {
		return personService.update(id, newName);
	}
	

}
