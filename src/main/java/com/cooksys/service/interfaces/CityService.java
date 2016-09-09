package com.cooksys.service.interfaces;

import java.util.List;

import com.cooksys.entity.AppCity;
import com.cooksys.entity.AppState;

public interface CityService {
	
	AppCity create(AppCity interest);

	List<AppCity> index();

	AppCity read(long id);

	AppCity update(long id, AppCity interestToUpdate);

	AppCity delete(long id);
	
	AppState readState(long id);
	
	AppCity updateState(long id, AppState stateToPut);
}
