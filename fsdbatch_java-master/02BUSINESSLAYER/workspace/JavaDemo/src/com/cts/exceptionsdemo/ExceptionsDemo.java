package com.cts.exceptionsdemo;

import java.io.FileNotFoundException;

public class ExceptionsDemo {
	
	public static int m2(int divisor) throws Exception{
		System.out.println("m2 method");
		if(divisor == 0){
			throw new Exception("Invalid Input!!");
		}
		int result = 4/divisor;
		return 100000;
	}
	
	public static void m1(){
		int result = 0;

			try {
				result = m2(0);
			} catch (Exception e) {
				e.printStackTrace();
				//Send and email
				}
	
		
		
		System.out.println("m1 method" + result);
	}
	
	public static void findCourse(int courseId) throws CourseNotFoundException, FileNotFoundException{
		if(courseId < 0){
			throw new CourseNotFoundException("Not found book for id :" + courseId);
		}
	}
	
	public static void main(String[] args)  {
		m1();
		
		try {
			findCourse(-34);
			
		} 

		catch (FileNotFoundException | CourseNotFoundException e) {
			e.printStackTrace();
		} 
catch (Exception e){
			
		}
		
		
		
		System.out.println("main method.. all is well, if it ends well");
	}

}
