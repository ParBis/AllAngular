package com.cts.ctsdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ctsdemo.Course;
import com.cts.ctsdemo.repo.ICourseRepo;

@RestController
public class TestController {
	
	@Autowired
	ICourseRepo repo;
	
	@RequestMapping("/courses")
	public List<Course> fetchAllCourses(){
//		Course course = new Course(12, "Angular", "Our UI framework!!");
//		Course course1 = new Course(12, "React", "We can use React also for UI framework!!");
		
//		List<Course> courses = new ArrayList<>();
//		courses.add(course); courses.add(course1);
		return repo.findAll();
	}

}
