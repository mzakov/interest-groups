package com.cooksys.model;

import java.util.ArrayList;
import java.util.List;

import com.cooksys.entity.AppPerson;

public class GetAllPeopleResponse {
	
	private long id;
	
	private String name;
	
	public GetAllPeopleResponse(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public static List<GetAllPeopleResponse> list(List<AppPerson> list)
	{
		ArrayList<GetAllPeopleResponse> result = new ArrayList<>();
		for(AppPerson user : list)
			result.add(new GetAllPeopleResponse(user.getId(), user.getName()));
		return result;
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
	
}
