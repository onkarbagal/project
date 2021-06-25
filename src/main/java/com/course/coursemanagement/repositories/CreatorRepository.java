package com.course.coursemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.course.coursemanagement.entities.Courseentity;
import com.course.coursemanagement.entities.Creatorentity;

public interface CreatorRepository extends CrudRepository<Creatorentity, Long>{

}
