package com.cooksys.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
public class AppPerson {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable=false)
	private long id;

	@Column(nullable=false)
	private String name;

	@ManyToOne(optional=false, fetch=FetchType.EAGER)
	private AppCity city;

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "person_interests")
	private Set<AppInterest> interests;

	@ManyToMany
	@JoinTable(name = "person_groups")
	private Set<AppGroup> groups;

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

	public Set<AppGroup> getGroups() {
		return groups;
	}

	public void setGroups(Set<AppGroup> groups) {
		this.groups = groups;
	}

//	public AppPerson() {
//
//	}
//
//	public AppPerson(String name, AppCity city) {
//		this.name = name;
//		this.city = city;
//	}
//
////	IS THAT OK???	
//	public void removeInterest(AppInterest interest) {
//		interests.remove(interest);
//	}
//	
////	IS THAT OK???
//	public void removeGroup(AppGroup group) {
//		groups.remove(group);
//	}
}
