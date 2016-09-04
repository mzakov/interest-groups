package com.cooksys.entity;

import java.util.List;

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

    @ManyToMany
    @JoinTable(name = "InterestPeople")
    @JsonIgnore
    private List<AppPerson> people;
    
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
}
