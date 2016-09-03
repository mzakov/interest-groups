package com.cooksys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.AppPerson;

public interface PersonRepository extends JpaRepository<AppPerson, Long>{
	
}
