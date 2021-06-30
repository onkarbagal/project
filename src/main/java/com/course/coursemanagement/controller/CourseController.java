package com.course.coursemanagement.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.course.coursemanagement.entities.Courseentity;
import com.course.coursemanagement.exception.NoContentException;
import com.course.coursemanagement.models.Course;
import com.course.coursemanagement.repositories.CourseRepository;
import com.course.coursemanagement.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService cs;

	@Autowired
	private CourseRepository cr;
	
	RestTemplate rt = new RestTemplate();

	@PostMapping("/save")
	public ResponseEntity<Course> saveIntocourseItemTable(@RequestBody Course course) {
		rt.postForObject("http://localhost:8082/notify", course, String.class);
		return new ResponseEntity<>(cs.saveData(course), HttpStatus.OK);
	}
	
	@GetMapping(path = "course/{id}")
	
	public ResponseEntity<Course> getdatabyid(@PathVariable("id") Long id) {
		Course courseData = null;
		try {
			courseData = cs.getCourseData(id);
		} catch (NoContentException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(courseData, HttpStatus.OK);

	}

	@PutMapping("/updatecourse/{id}")
	public ResponseEntity<Course> updatecourse(@PathVariable("id") Long id, @RequestBody Course course) {

		Optional<Courseentity> courseData = cr.findById(id);

		if (courseData.isPresent()) {

			return new ResponseEntity<>(cs.updateCourseData(course), HttpStatus.OK);

		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

	@DeleteMapping("/deletecourse/{id}")
	public ResponseEntity<HttpStatus> deletecourse(@PathVariable("id") Long id) {
		try {

			cr.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@GetMapping(path = "location/{loc}")
	public ResponseEntity<Course> bylocation(@PathVariable("loc") String loc){
		try {
			return new ResponseEntity<>(cs.getCourseDatabyLocation(loc), HttpStatus.OK);
		} catch (NoContentException e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}

	}
	

}
