package com.cooksys.service.interfaces;

import java.util.List;
import java.util.Set;

import com.cooksys.entity.AppCity;
import com.cooksys.entity.AppGroup;
import com.cooksys.entity.AppInterest;
import com.cooksys.entity.AppPerson;

public interface PersonService {

	List<AppPerson> index();

	AppPerson create(AppPerson person);

	AppPerson read(long id);

	AppPerson update(long id, AppPerson personToUpdate);

	AppPerson delete(long id);

	AppCity readCity(long id);

	AppPerson updateCity(long id, AppCity cityToPut);

	Set<AppInterest> indexInterests(long id);

	AppPerson updateInterests(long id, AppInterest interestToAdd);

	AppPerson deleteInterest(long id, long interest_id);

	Set<AppGroup> indexGroups(long id);

	AppPerson updateGroups(long id, com.cooksys.entity.AppGroup groupToAdd);

	AppPerson deleteGroup(long id, long group_id);

}
