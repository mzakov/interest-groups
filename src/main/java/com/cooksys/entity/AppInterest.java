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
	private String interest;

    @ManyToOne
    @JoinColumn(name = "Owner")
    @JsonIgnore
    private AppPerson owner;

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

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public AppPerson getOwner() {
		return owner;
	}

	public void setOwner(AppPerson owner) {
		this.owner = owner;
	}

	public List<AppPerson> getPeople() {
		return people;
	}

	public void setPeople(List<AppPerson> people) {
		this.people = people;
	}
}
