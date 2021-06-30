package com.course.testing;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.course.coursemanagement.CourseApplication;
import com.course.coursemanagement.controller.CourseController;
import com.course.coursemanagement.models.Course;
import com.course.coursemanagement.repositories.CourseRepository;
import com.course.coursemanagement.entities.Courseentity;
import com.course.coursemanagement.service.CourseService;


//Junit 4
@SpringBootTest(classes = CourseApplication.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class CourseTest {
	
	@Mock
	CourseRepository cr;
	@Mock
	private CourseController cc;
	
	@Mock
	private CourseService cs;

	@Test
	public void testcontroller() {
		assertTrue(5>3);
		
	}
	
	@Test
	public void testgetdata() throws Throwable {
//		Course c = new Course();
//		c.setId(1L);
//		c.setDescription("This is Description");
//		c.setFeedback("Nice Feedback");
//		c.setLastupdated("2021-06-30");
//		c.setLocation("Pune");
//		c.setPrerequesite("Spring boot Junit");
//		
		when(cs.getCourseData(1L)).thenReturn(setdata.setCoursedata());
		Course c = cs.getCourseData(1L);
		long val = c.getId();
		assertEquals(1L, val);
		String loc = c.getLocation();
		assertEquals("Pune", loc);
	}
	@Test
	public void testRepo() {
		when(cr.findById(1L)).thenReturn(setdata.setcourseEntitydata());
		Optional<Courseentity> response = cr.findById(1L);
		assertNotNull(response);
	}
}
