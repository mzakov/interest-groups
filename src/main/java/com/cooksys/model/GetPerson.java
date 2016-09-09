package com.cooksys.model;

import java.util.List;
import java.util.Set;

import com.cooksys.entity.AppCity;
import com.cooksys.entity.AppInterest;
import com.cooksys.entity.AppPerson;

public class GetPerson {
	
	private long id;
	
	private String name;
	
	private AppCity city;
	
	private Set<AppInterest> interests;
	
	private List<GetAllResponse> groups;
	
	public GetPerson(AppPerson person) {
		this.id = person.getId();
		this.name = person.getName();
		this.city = person.getCity();
		this.interests = person.getInterests();
		this.groups = GetAllResponse.listGroups(person.getGroups());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AppCity getCity() {
		return city;
	}

	public void setCity(AppCity city) {
		this.city = city;
	}

	public Set<AppInterest> getInterests() {
		return interests;
	}

	public void setInterests(Set<AppInterest> interests) {
		this.interests = interests;
	}

	public List<GetAllResponse> getGroups() {
		return groups;
	}

	public void setGroups(List<GetAllResponse> groups) {
		this.groups = groups;
	}

}
