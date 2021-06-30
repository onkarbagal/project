package com.course.testing;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.course.coursemanagement.CourseApplication;
import com.course.coursemanagement.controller.CourseController;

@SpringBootTest(classes = CourseApplication.class)
@RunWith(SpringRunner.class)
public class CourseTest {
	
	@Autowired
	private CourseController cc;

	@Test
	public void testcontroller() {
		assertTrue(5>3);
		
		
	}

}
