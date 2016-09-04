package com.cooksys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.AppInterest;

public interface InterestsRepository extends JpaRepository<AppInterest, Long> {
	
	List<AppInterest> findAllByPeople_id(long people_id);
	
//	AppInterest findOneByPeople_idAndInterests_id(long people_id, long interests_id);
}
