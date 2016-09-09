package com.cooksys.entity;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "name"), name = "AppInterest")
public class AppInterest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable=false)
	private long id;

	@Column(nullable=false)
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "interest", fetch=FetchType.LAZY)
	private Set<AppGroup> groups;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "interests", fetch=FetchType.LAZY)
	private Set<AppPerson> people;

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

	public Set<AppPerson> getPeople() {
		return people;
	}

	public void setPeople(Set<AppPerson> people) {
		this.people = people;
	}

	public Set<AppGroup> getGroups() {
		return groups;
	}

	public void setGroups(Set<AppGroup> groups) {
		this.groups = groups;
	}
	
//	public AppInterest() {
//
//	}
//
//	public AppInterest(String name) {
//		this.name = name;
//	}

}
