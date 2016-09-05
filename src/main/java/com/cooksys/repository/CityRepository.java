package com.cooksys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.AppCity;

public interface CityRepository extends JpaRepository<AppCity, Long> {

	List<AppCity> findAllByState_id(long state_id);
}
