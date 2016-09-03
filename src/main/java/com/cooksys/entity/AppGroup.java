package com.cooksys.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class AppGroup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "Owner")
	@JsonIgnore
	private AppPerson owner;
	
	@ManyToMany
	@JoinTable(name = "GroupPersons")
	@JsonIgnore
	private List<AppPerson> members;

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

	public AppPerson getOwner() {
		return owner;
	}

	public void setOwner(AppPerson owner) {
		this.owner = owner;
	}

	public List<AppPerson> getMembers() {
		return members;
	}

	public void setMembers(List<AppPerson> members) {
		this.members = members;
	}
	
	
	
}
