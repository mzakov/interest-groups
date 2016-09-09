package com.cooksys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.AppInterest;
import com.cooksys.repository.InterestsRepository;
import com.cooksys.service.interfaces.InterestService;

@Service
public class InterestServiceImpl implements InterestService {


	private final InterestsRepository intRepo;

	@Autowired
	public InterestServiceImpl(InterestsRepository intRepo) {
		super();
		this.intRepo = intRepo;
	}

	// GET /api/interests
	@Override
	public List<AppInterest> index() {
		return intRepo.findAll();
	}

	// POST /api/interests
	@Override
	public AppInterest create(AppInterest interest) {
		return intRepo.save(interest);
	}

	// GET /api/interests/{id}
	@Override
	public AppInterest read(long id) {
		return intRepo.findOne(id);
	}

	// PATCH /api/interests/{id}
	@Override
	public AppInterest update(long id, AppInterest interestToUpdate) {
		interestToUpdate.setId(id);
		return intRepo.save(interestToUpdate);
	}

	// DELETE /api/interests/{id}
	@Override
	public AppInterest delete(long id) {
		AppInterest result = this.read(id);
		intRepo.delete(id);
		return result;
	}

}
