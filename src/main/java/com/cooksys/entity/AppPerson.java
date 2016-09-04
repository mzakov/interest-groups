package com.cooksys.entity;

import java.util.List;
import javax.persistence.*;


@Entity
@Table
public class AppPerson {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String name;
	
	@ManyToOne
	@JoinColumn
	private AppCity city;	

	@ManyToMany(mappedBy = "people")
	private List<AppInterest> interests;
	
	@ManyToMany(mappedBy = "members")
	private List<AppGroup> groups;
	
	public AppPerson() {
		
	}
	
	public AppPerson(String name, AppCity city) {
		this.name = name;
		this.city = city;
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

	public List<AppInterest> getInterests() {
		return interests;
	}

	public void setInterests(List<AppInterest> interests) {
		this.interests = interests;
	}

	public List<AppGroup> getGroups() {
		return groups;
	}

	public void setGroups(List<AppGroup> groups) {
		this.groups = groups;
	}

}
