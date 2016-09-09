package com.cooksys.service.interfaces;

import java.util.List;

import com.cooksys.entity.AppInterest;

public interface InterestService {

	AppInterest create(AppInterest interest);

	List<AppInterest> index();

	AppInterest read(long id);

	AppInterest update(long id, AppInterest interestToUpdate);

	AppInterest delete(long id);
}
