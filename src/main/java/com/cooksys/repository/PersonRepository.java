package com.cooksys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.AppPerson;

public interface PersonRepository extends JpaRepository<AppPerson, Long> {

	List<AppPerson> findAllByCity_id(long city_id);

	List<AppPerson> findAllByGroups_id(long groups_id);
}
