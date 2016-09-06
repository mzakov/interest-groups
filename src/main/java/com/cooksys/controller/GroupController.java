package com.cooksys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cooksys.entity.AppCity;
import com.cooksys.entity.AppGroup;
import com.cooksys.entity.AppInterest;
import com.cooksys.model.GetAllResponse;
import com.cooksys.service.GroupService;

@RestController
@RequestMapping("groups")
public class GroupController {

	@Autowired
	private GroupService groupService;

	// GET /api/groups
	@RequestMapping(method = RequestMethod.GET)
	public List<GetAllResponse> allGroups() {
		return groupService.getAll();
	}

	// POST /api/groups
	@RequestMapping(path = "/{name},{city_id},{interest_id}", method = RequestMethod.POST)
	public AppGroup newGroup(@PathVariable("name") String name, @PathVariable("city_id") long city_id,
			@PathVariable("interest_id") long interest_id) {
		return groupService.set(name, city_id, interest_id);
	}

	// GET /api/groups/{id}
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public AppGroup getGroup(@PathVariable("id") long id) {
		return groupService.get(id);
	}

	// PATCH /api/groups/{id}
	@RequestMapping(path = "/{id}/{newName}", method = RequestMethod.PATCH)
	public AppGroup updateGroup(@PathVariable("id") long id, @PathVariable("newName") String newName) {
		return groupService.update(id, newName);
	}

	// DELETE /api/groups/{id}
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public String deleteGroup(@PathVariable("id") long id) {
		return groupService.delete(id);
	}

	// GET /api/groups/{id}/city
	@RequestMapping(path = "/{id}/city", method = RequestMethod.GET)
	public AppCity getCity(@PathVariable("id") long id) {
		return groupService.getCity(id);
	}

	// PUT /api/groups/{id}/city
	@RequestMapping(path = "/{id}/city/{city_id}", method = RequestMethod.PUT)
	public AppGroup putCity(@PathVariable("id") long id, @PathVariable("city_id") long city_id) {
		return groupService.putCity(id, city_id);
	}

	// GET /api/groups/{id}/interest
	@RequestMapping(path = "/{id}/interest", method = RequestMethod.GET)
	public AppInterest interest(@PathVariable("id") long id) {
		return groupService.getInterest(id);
	}

	// PUT /api/groups/{id}/interest
	@RequestMapping(path = "/{id}/interest/{interest_id}", method = RequestMethod.PUT)
	public AppGroup putInterest(@PathVariable("id") long id, @PathVariable("interest_id") long interest_id) {
		return groupService.putInterest(id, interest_id);
	}

	// GET /api/groups/{id}/members
	@RequestMapping(path = "/{id}/members", method = RequestMethod.GET)
	public List<GetAllResponse> allPeople(@PathVariable("id") long id) {
		return groupService.getAllMembers(id);
	}

	// PUT /api/groups/{id}/members
	@RequestMapping(path = "/{id}/members/{member_id}", method = RequestMethod.PUT)
	public List<GetAllResponse> putMember(@PathVariable("id") long id, @PathVariable("member_id") long member_id) {
		return groupService.putMember(id, member_id);
	}

	// DELETE /api/groups/{id}/members/{id}
	@RequestMapping(path = "/{id}/members/{member_id}", method = RequestMethod.DELETE)
	public AppGroup deleteMember(@PathVariable("id") long id, @PathVariable("member_id") long member_id) {
		return groupService.deleteMember(id, member_id);
	}
}
