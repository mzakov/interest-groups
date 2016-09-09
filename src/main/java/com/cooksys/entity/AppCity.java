package com.cooksys.entity;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"state_id", "name"}))
public class AppCity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable=false)
	private long id;

	@Column(nullable=false)
	private String name;

	@ManyToOne(optional=false, fetch=FetchType.EAGER)
	@JoinColumn(name="state_id") //State is not a column type. This is the column that represents a join between entity, not contains the entity
	private AppState state;

	@OneToMany(mappedBy = "city", fetch=FetchType.LAZY)
	@JsonIgnore
	private Set<AppGroup> groups;

	@OneToMany(mappedBy = "city", fetch=FetchType.LAZY)
	@JsonIgnore
	private Set<AppPerson> people;

	public Set<AppPerson> getPeople() {
		return people;
	}

	public void setPeople(Set<AppPerson> people) {
		this.people = people;
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
//	public AppCity() {
//
//	}
//
//	public AppCity(String name, AppState state) {
//		this.name = name;
//		this.state = state;
//	}
}
