package com.cooksys.service.interfaces;

import java.util.List;

import com.cooksys.entity.AppState;

public interface StateService {

	List<AppState> index();

	AppState create(AppState state);

	AppState read(long id);

	AppState update(long id, AppState stateToUpdate);

	AppState delete(long id);

}
