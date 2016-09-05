package com.cooksys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.AppGroup;

public interface GroupsRepository extends JpaRepository<AppGroup, Long> {

	List<AppGroup> findAllByMembers_id(long members_id);

	List<AppGroup> findAllByInterest_id(long interest_id);

	List<AppGroup> findAllByCity_id(long city_id);
}
