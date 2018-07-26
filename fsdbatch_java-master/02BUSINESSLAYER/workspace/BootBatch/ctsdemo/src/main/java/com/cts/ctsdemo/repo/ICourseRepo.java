package com.cts.ctsdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.ctsdemo.Course;

public interface ICourseRepo extends JpaRepository<Course, Integer> {

}
