package com.cooksys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cooksys.entity.AppState;
import com.cooksys.service.StateService;

@RestController
@RequestMapping("states")
public class StateController {
		
		@Autowired
		private StateService stateService;

//		GET     /api/states
		@RequestMapping(method=RequestMethod.GET)
		public List<AppState> allStates() {
			return stateService.getAll();
		}
		
//		POST    /api/states
		@RequestMapping(path="/{name}", method=RequestMethod.POST)
		public AppState newState(@PathVariable("name") String name) {
			return stateService.set(name);
		}
		
//		GET     /api/states/{id}
		@RequestMapping(path="/{id}", method=RequestMethod.GET)
		public AppState getState(@PathVariable("id") long id) {
			return stateService.get(id);
		}

//		PATCH   /api/states/{id}
		@RequestMapping(path="/{id}/{newName}", method=RequestMethod.PATCH)
		public AppState updateState(@PathVariable("id") long id, @PathVariable("newName") String newName) {
			return stateService.update(id, newName);
		}
		
//		DELETE  /api/people/{id}
		@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
		public String deleteState(@PathVariable("id") long id) {
			return stateService.delete(id);
		}
}

