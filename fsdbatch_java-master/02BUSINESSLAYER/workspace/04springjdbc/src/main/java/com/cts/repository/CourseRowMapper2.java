package com.cts.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.entity.Course2;

public class CourseRowMapper2 implements RowMapper<Course2>{

	@Override
	public Course2 mapRow(ResultSet rs, int rowNum) throws SQLException {
		Course2 course = null;

			Integer id = rs.getInt(1);
			String name = rs.getString(2);
			String description = rs.getString(3);
			course = new Course2(id, name, description);
			

		return course;
	}

}
