package com.cooksys.entity;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class AppCity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String name;
	
	@ManyToOne
	@JoinColumn
	private AppState state;
	
	@OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<AppGroup> groups;
	
	@OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
	@JsonIgnore
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

	public AppState getState() {
		return state;
	}

	public void setState(AppState state) {
		this.state = state;
	}

	public Set<AppGroup> getGroups() {
		return groups;
	}

	public void setGroups(Set<AppGroup> groups) {
		this.groups = groups;
	}


}
