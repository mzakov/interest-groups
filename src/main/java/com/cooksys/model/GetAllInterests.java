package com.cooksys.model;

import java.util.ArrayList;
import java.util.List;

import com.cooksys.entity.AppInterest;

public class GetAllInterests {
	
	private long id;
	
	private String name;
	
	public GetAllInterests(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public static List<GetAllInterests> list(List<AppInterest> list)
	{
		ArrayList<GetAllInterests> result = new ArrayList<>();
		for(AppInterest interest : list)
			result.add(new GetAllInterests(interest.getId(), interest.getName()));
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
