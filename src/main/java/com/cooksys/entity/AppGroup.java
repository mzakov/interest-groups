package com.cooksys.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"city_id", "interest_id", "name"}))
public class AppGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable=false)
	private long id;

	@Column(nullable=false)
	private String name;

	@ManyToOne(optional=false, fetch=FetchType.EAGER)
	@JoinColumn(name="city_id")
	private AppCity city;

	@ManyToOne(optional=false, fetch=FetchType.EAGER)
	@JoinColumn(name="interest_id")
	private AppInterest interest;

	@ManyToMany(mappedBy = "groups")
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

//	public AppGroup() {
//
//	}
//
//	public AppGroup(String name, AppCity city, AppInterest interest) {
//		this.name = name;
//		this.city = city;
//		this.interest = interest;
//	}
//
////	IS THAT OK???
//	public void removeMember(AppPerson member) {
//		members.remove(member);
//	}
}
