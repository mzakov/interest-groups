package com.cooksys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cooksys.entity.AppPerson;
import com.cooksys.model.GetAllPeopleResponse;
import com.cooksys.service.PersonService;

@RestController
@RequestMapping("person")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/{id}")
	public AppPerson person(@PathVariable("id") long id) {
		return personService.get(id);
	}
	
	@RequestMapping("allPeople")
	public List<GetAllPeopleResponse> allPeople() {
		return personService.getAll();
	}
}
