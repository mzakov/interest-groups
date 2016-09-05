package com.cooksys.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "AppInterest")
public class AppInterest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String name;

	public AppInterest() {

	}

	public AppInterest(String name) {
		this.name = name;
	}

	@ManyToMany(mappedBy = "interests")
	@JsonIgnore
	private List<AppPerson> people;

	@OneToMany(mappedBy = "interest")
	@JsonIgnore
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

	public List<AppPerson> getPeople() {
		return people;
	}

	public void setPeople(List<AppPerson> people) {
		this.people = people;
	}

	public Set<AppGroup> getGroups() {
		return groups;
	}

	public void setGroups(Set<AppGroup> groups) {
		this.groups = groups;
	}

}
