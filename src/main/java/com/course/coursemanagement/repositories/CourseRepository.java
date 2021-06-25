package com.course.coursemanagement.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.course.coursemanagement.entities.Courseentity;



@Repository
public interface CourseRepository extends CrudRepository<Courseentity, Long> {

	Optional<Courseentity> findByLocation(String location);
	
	
}
