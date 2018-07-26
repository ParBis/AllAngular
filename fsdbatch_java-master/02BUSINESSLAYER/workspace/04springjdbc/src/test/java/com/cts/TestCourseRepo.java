package com.cts;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cts.entity.Course;
import com.cts.entity.Course2;
import com.cts.repository.CourseRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestCourseRepo {
	
	@Autowired
	CourseRepository repo;


//	@Test
	public void testFetchCourse(){
		int result = repo.fetchAllCourses();
		assertEquals("Two courses should be present", result, 2);
	}
	
	@Test
	public void testFetchCourseByName(){
		Course course = repo.fetchAllCoursesByName("React");
		assertEquals("Two courses should be present", course.getTitle(), "React");
	}
	

	@Test
	public void testFetchResultSetExtractor(){
		List<Course2> listCourse2 = repo.testFetchResultSetExtractor();
		System.out.println("ExtractList -- >" + listCourse2);
		//assertEquals("Two courses should be present", course.getTitle(), "React");
	}
}
