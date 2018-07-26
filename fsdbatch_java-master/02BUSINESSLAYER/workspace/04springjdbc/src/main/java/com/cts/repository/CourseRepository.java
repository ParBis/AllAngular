package com.cts.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.cts.entity.Course;
import com.cts.entity.Course2;

@Repository
public class CourseRepository {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public int fetchAllCourses(){
		   String SQL = "select * from Course c";
//		   Map<String, Object> courseMap = jdbcTemplateObject.queryForMap(SQL);
//		   System.out.println(courseMap);
//		   System.out.println(courseMap.get("name"));
//		   return courseMap.size();
		   
		   List<Map<String, Object>> coursesList= jdbcTemplateObject.queryForList(SQL);
		   System.out.println(coursesList);
		   for(Map<String, Object> courseMap: coursesList){
			   System.out.println(courseMap.get("name"));
		   }
		   return coursesList.size();
	   }

	public Course fetchAllCoursesByName(String string) {
		String SQL = "select * from Course c where c.name='React'" ;
		
		// Single Row
		CourseRowMapper rowMapper = new CourseRowMapper();
		Course course = jdbcTemplateObject.queryForObject(SQL, rowMapper);
		System.out.println(course);
		
		// Single data
		String SQL1 = "select c.id from Course c" ;
		List<Integer> courseCount = jdbcTemplateObject.queryForList(SQL1, Integer.class);
		System.out.println("courseCount--> " + courseCount);
		
		// List of row
		String SQL2 = "select * from Course c" ;
		List<Course2> courseList = jdbcTemplateObject.query(SQL2, new CourseRowMapper2());
		System.out.println("courseList--> " + courseList);
		
		return course;
	}
	
	
	// fetch All Row using ResultSetExtractor
	public List<Course2> testFetchResultSetExtractor() {
        return jdbcTemplateObject.query("select * from Course c", 
         new ResultSetExtractor<List<Course2>>() {

            @Override
            public List<Course2> extractData(ResultSet rs)
                    throws SQLException, DataAccessException {
                List<Course2> list = new ArrayList<Course2>();  
                while(rs.next()){
                	Course2 emp = new Course2();
                    emp.setId(rs.getInt("id"));
                    emp.setName(rs.getString("name"));
                    emp.setDescription(rs.getString("description"));
                    list.add(emp);
                }
                return list;
            }  
        });
    }
	
}

