package com.cts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CoursesServlet")
public class CoursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Course course1 = new Course(123, "Angular", "ds klgsa jkgsdkl jkdgdks gjklsdk gdskd sksdksk");
		Course course2 = new Course(234, "React", "jkdgdks gjklsdk gdskd sksdksk");
		
		List<Course> courses = new ArrayList<>();
		courses.add(course1);
		courses.add(course2);
		
		request.setAttribute("courses", courses);
		
		// Attach a view to display list of courses
		RequestDispatcher rd = request.getRequestDispatcher("courses.jsp");
		rd.forward(request, response);
		
		response.getWriter().println(courses);

	
	}
}
