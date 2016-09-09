package com.cooksys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cooksys.entity.AppCity;
import com.cooksys.entity.AppGroup;
import com.cooksys.entity.AppInterest;
import com.cooksys.entity.AppPerson;
import com.cooksys.service.interfaces.GroupService;

@RestController
@RequestMapping("groups")
public class GroupController {

	private final GroupService groupService;

	@Autowired
	public GroupController(GroupService groupService) {
		super();
		this.groupService = groupService;
	}
	
	// GET /api/groups
	@RequestMapping(method = RequestMethod.GET)
	public List<AppGroup> index() {
		return groupService.index();
	}

	// POST /api/groups
	@RequestMapping(method = RequestMethod.POST)
	public AppGroup create(@RequestBody AppGroup group) {
		return groupService.create(group);
	}

	// GET /api/groups/{id}
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public AppGroup read(@PathVariable("id") long id) {
		return groupService.read(id);
	}

	// PATCH /api/groups/{id}
	@RequestMapping(value = "{id}", method = RequestMethod.PATCH)
	public AppGroup update(@PathVariable("id") long id, @RequestBody AppGroup groupToUpdate) {
		return groupService.update(id, groupToUpdate);
	}

	// DELETE /api/groups/{id}
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public AppGroup delete(@PathVariable("id") long id) {
		return groupService.delete(id);
	}

	// GET /api/groups/{id}/city
	@RequestMapping(path = "/{id}/city", method = RequestMethod.GET)
	public AppCity readCity(@PathVariable("id") long id) {
		return groupService.readCity(id);
	}

	// PUT /api/groups/{id}/city
	@RequestMapping(path = "/{id}/city", method = RequestMethod.PUT)
	public AppGroup updateCity(@PathVariable("id") long id, @RequestBody AppCity cityToPut) {
		return groupService.updateCity(id, cityToPut);
	}

	// GET /api/groups/{id}/interest
	@RequestMapping(path = "/{id}/interest", method = RequestMethod.GET)
	public AppInterest readInterest(@PathVariable("id") long id) {
		return groupService.readInterest(id);
	}

	// PUT /api/groups/{id}/interest
	@RequestMapping(path = "/{id}/interest", method = RequestMethod.PUT)
	public AppGroup updateInterest(@PathVariable("id") long id, @RequestBody AppInterest interestToPut) {
		return groupService.updateInterest(id, interestToPut);
	}

	// GET /api/groups/{id}/members
	@RequestMapping(path = "/{id}/members", method = RequestMethod.GET)
	public List<AppPerson> indexPeople(@PathVariable("id") long id) {
		return groupService.indexPeople(id);
	}

	// PUT /api/groups/{id}/members
	@RequestMapping(path = "/{id}/members", method = RequestMethod.PUT)
	public AppGroup updateMembers(@PathVariable("id") long id, @RequestBody AppPerson memberToAdd) {
		return groupService.updateMembers(id, memberToAdd);
	}

	// DELETE /api/groups/{id}/members
	@RequestMapping(path = "/{id}/members", method = RequestMethod.DELETE)
	public AppGroup deleteMember(@PathVariable("id") long id, @PathVariable("member_id") long member_id) {
		return groupService.deleteMember(id, member_id);
	}
}
