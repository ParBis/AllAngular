package com.cts.exceptionsdemo;

public class CourseNotFoundException extends Exception{
	
	
	CourseNotFoundException(){
		super("Course Not Found!!");
	}
	CourseNotFoundException(String message){
		super(message);
	}

}
