package com.cooksys.entity;

import javax.persistence.*;

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


}
