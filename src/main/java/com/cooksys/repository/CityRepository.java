package com.cooksys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.AppCity;

public interface CityRepository extends JpaRepository<AppCity, Long>{

}