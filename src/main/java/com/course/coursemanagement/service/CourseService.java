package com.course.coursemanagement.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.course.coursemanagement.entities.Courseentity;
import com.course.coursemanagement.entities.Creatorentity;
import com.course.coursemanagement.entities.Skillentity;
import com.course.coursemanagement.exception.NoContentException;
import com.course.coursemanagement.models.Course;
import com.course.coursemanagement.repositories.CourseRepository;
import com.course.coursemanagement.repositories.CreatorRepository;
import com.course.coursemanagement.repositories.SkillRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository cr;
	
	@Autowired
	private SkillRepository skillRepository;
	
	@Autowired
	private CreatorRepository creatorRepository;

	public Course saveData(Course course) {
		Courseentity entity = cr.save(mapObjectToEntity(course));
		return getdata(entity);
	}

	public Courseentity mapObjectToEntity(Course course) {
		Courseentity entity = new Courseentity();
		
		
		entity.setId(course.getId());
		entity.setDescription(course.getDescription());
		entity.setPrerequesite(course.getPrerequesite());
		
		entity.setLastupdated(course.getLastupdated());
		
		entity.setFeedback(course.getFeedback());
		entity.setSkill(addSkill(course));
		entity.setCreator(addCreator(course));
		entity.setLocation(course.getLocation());
		
		return entity;
	}

	private List<Skillentity> addSkill(Course course) {
		List<Skillentity> skillList = new ArrayList<>();
		int n = course.getSkills().size();
		long skillId = 0;
		String name = null;

		for (int i = 0; i < n; i++) {
			skillId = course.getSkills().get(i).getId();
			name = course.getSkills().get(i).getName();

			Skillentity skill = new Skillentity(skillId, name);

			skillList.add(skill);

		}

		return skillList;

	}

	private List<Skillentity> addSkill(Courseentity course) {
		List<Skillentity> skillList = new ArrayList<>();
		int n = course.getSkill().size();
		long skillId = 0;
		String name = null;

		for (int i = 0; i < n; i++) {
			skillId = course.getSkill().get(i).getId();
			name = course.getSkill().get(i).getName();

			Skillentity skill = new Skillentity(skillId, name);
			
			skillList.add(skill);

		}

		return skillList;

	}

	private List<Creatorentity> addCreator(Course course) {

		
		List<Creatorentity> creatorList = new ArrayList<>();
		int n = course.getCreator().size();
		long creatorId = 0;
		String name = null;

		for (int i = 0; i < n; i++) {
			creatorId = course.getCreator().get(i).getId();
			name = course.getCreator().get(i).getName();

			Creatorentity creator = new Creatorentity(creatorId, name);
			
			creatorList.add(creator);

		}

		return creatorList;

	}
	

	private List<Creatorentity> addCreator(Courseentity course) {

		
		List<Creatorentity> creatorList = new ArrayList<>();
		int n = course.getCreator().size();
		long creatorId = 0;
		String name = null;

		for (int i = 0; i < n; i++) {
			creatorId = course.getCreator().get(i).getId();
			name = course.getCreator().get(i).getName();

			Creatorentity creator = new Creatorentity(creatorId, name);
			
			creatorList.add(creator);

		}

		return creatorList;

	}

	public Course getdata(Courseentity entity) {

		Course course = new Course();
		course.setId(entity.getId());
		course.setDescription(entity.getDescription());
		course.setPrerequesite(entity.getPrerequesite());
		course.setLastupdated(entity.getLastupdated());
		course.setFeedback(entity.getFeedback());
		course.setSkills(addSkill(entity));
		course.setCreator(addCreator(entity));
		course.setLocation(entity.getLocation());

		return course;
	}

	public Course getCourseData(Long id) throws NoContentException {

		Optional<Courseentity> entity = cr.findById(id);
		if (!entity.isPresent()) {
			throw new NoContentException(HttpStatus.NO_CONTENT);
		}
		return getdata(entity.get());

	}

	public Course updateCourseData(Course course) {
		Courseentity entity = cr.save(mapObjectToEntity(course));
		return getdata(entity);

	}

	public Course getCourseDatabyLocation(String location) throws NoContentException {

		Optional<Courseentity> entity = cr.findByLocation(location);
		if (!entity.isPresent()) {
			throw new NoContentException(HttpStatus.NO_CONTENT);
		}
		return getdata(entity.get());

	}
	
	public int demo() {
		return 10;
	}
	

}