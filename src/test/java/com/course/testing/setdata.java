package com.course.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.course.coursemanagement.entities.Courseentity;
import com.course.coursemanagement.entities.Creatorentity;
import com.course.coursemanagement.entities.Skillentity;
import com.course.coursemanagement.models.Course;

public class setdata {
	
	public static Optional<Courseentity> setcourseEntitydata()
	{
		Courseentity ce=new Courseentity();
		ce.setId(1L);
		ce.setDescription("This is course description");
		ce.setFeedback("Awesome");
		ce.setPrerequesite("C++");
		ce.setLocation("Pune");
		
		Skillentity se=new Skillentity();
		se.setId(1);
		se.setName("Javacore");
		Creatorentity c=new Creatorentity();
		c.setId(1L);
		c.setName("Onkar");
		List<Creatorentity> cre= new ArrayList<>();
		cre.add(c);
		List<Skillentity> skl=new ArrayList<>();
		skl.add(se);
		ce.setSkill(skl);
		ce.setCreator(cre);
		return Optional.of(ce);
	}
	public static Course setCoursedata()
	{
		Course ce = new Course();
		ce.setId(1L);
		ce.setDescription("This is course description");
		ce.setFeedback("Awesome");
		ce.setPrerequesite("C++");
		ce.setLocation("Pune");
		ce.setLastupdated("2021-06-30");
		
		Skillentity se=new Skillentity();
		se.setId(1L);
		se.setName("Javacore");
		Creatorentity c=new Creatorentity();
		c.setId(1L);
		c.setName("Onkar");
		List<Creatorentity> cre= new ArrayList<>();
		cre.add(c);
		List<Skillentity> skl=new ArrayList<>();
		skl.add(se);
		ce.setSkills(skl);
		ce.setCreator(cre);
		return ce;
	}

}
