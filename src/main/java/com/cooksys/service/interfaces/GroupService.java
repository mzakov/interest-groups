package com.cooksys.service.interfaces;

import java.util.List;

import com.cooksys.entity.AppCity;
import com.cooksys.entity.AppGroup;
import com.cooksys.entity.AppInterest;
import com.cooksys.entity.AppPerson;

public interface GroupService {

	AppGroup create(AppGroup interest);

	List<AppGroup> index();

	AppGroup read(long id);

	AppGroup update(long id, AppGroup interestToUpdate);

	AppGroup delete(long id);

	AppCity readCity(long id);

	AppGroup updateCity(long id, AppCity cityToPut);
	
	AppInterest readInterest(long id);

	AppGroup updateInterest(long id, AppInterest interestToPut);

	List<AppPerson> indexPeople(long id);

	AppGroup updateMembers(long id, AppPerson personToAdd);

	AppGroup deleteMember(long id, long member_id);

}
