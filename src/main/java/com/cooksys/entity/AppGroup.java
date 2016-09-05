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
	@JoinColumn
	private AppCity city;

	@ManyToOne
	@JoinColumn
	private AppInterest interest;

	@ManyToMany(mappedBy = "groups")
	@JsonIgnore
	private List<AppPerson> members;

	public AppGroup() {

	}

	public AppGroup(String name, AppCity city, AppInterest interest) {
		this.name = name;
		this.city = city;
		this.interest = interest;
	}

//	IS THAT OK???
	public void removeMember(AppPerson member) {
		members.remove(member);
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

	public AppCity getCity() {
		return city;
	}

	public void setCity(AppCity city) {
		this.city = city;
	}

	public AppInterest getInterest() {
		return interest;
	}

	public void setInterest(AppInterest interest) {
		this.interest = interest;
	}

	public List<AppPerson> getMembers() {
		return members;
	}

	public void setMembers(List<AppPerson> members) {
		this.members = members;
	}

}
