package com.cooksys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.AppPerson;
import com.cooksys.model.GetAllPeopleResponse;
import com.cooksys.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository repo;
	
	public List<GetAllPeopleResponse> getAll()
	{
		return GetAllPeopleResponse.list(repo.findAll());
	}
	
	public AppPerson get(long id)
	{
		return repo.findOne(id);
	}

}
