package com.cooksys.entity;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames = "name"))
public class AppState {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable=false)
	private long id;

	@Column(nullable=false)
	private String name;

	@OneToMany(mappedBy = "state", fetch=FetchType.LAZY)
	@JsonIgnore
	private Set<AppCity> cities;

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

	public Set<AppCity> getCities() {
		return cities;
	}

	public void setCities(Set<AppCity> cities) {
		this.cities = cities;
	}
//	public AppState() {
//
//	}
//
//	public AppState(String name) {
//		this.name = name;
//	}
}
