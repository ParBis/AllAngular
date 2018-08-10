package com.cts.adv.annotations;

import com.cts.adv.annotations.Author.Type;


public class Employee {
	
	@Author(name="Ravi", email="ravi@gmail.com", type=Type.PERMANENT)
	public String name;
	
	@Author(name="Ravi", email="ravi@gmail.com", type=Type.PERMANENT)
	public Double salary;
	
	@Author(name="Priya", email="priya@gmail.com", type=Type.PERMANENT)
	public int age;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	Employee(){
		
	}

	public void increment(){
		
	}

}
