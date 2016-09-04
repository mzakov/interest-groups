package com.cooksys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.AppState;

public interface StateRepository extends JpaRepository<AppState, Long>{

}
