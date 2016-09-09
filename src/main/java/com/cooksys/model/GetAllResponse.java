package com.cooksys.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.cooksys.entity.AppGroup;
import com.cooksys.entity.AppPerson;

public class GetAllResponse {

	private long id;

	private String name;

	public GetAllResponse(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public static List<GetAllResponse> listPeople(Set<AppPerson> set) {
		ArrayList<GetAllResponse> result = new ArrayList<>();
		for (AppPerson user : set)
			result.add(new GetAllResponse(user.getId(), user.getName()));
		return result;
	}
	
	public static List<GetAllResponse> listGroups(Set<AppGroup> set) {
		ArrayList<GetAllResponse> result = new ArrayList<>();
		for (AppGroup group : set)
			result.add(new GetAllResponse(group.getId(), group.getName()));
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
