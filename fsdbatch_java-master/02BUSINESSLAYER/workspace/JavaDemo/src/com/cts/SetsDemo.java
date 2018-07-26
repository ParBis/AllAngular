package com.cts;

import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.SynchronousQueue;

public class SetsDemo {
	
	public static void main(String[] args) {
		
		Employee emp1 = new Employee(1l, "Ravi", 34433.33);
		Employee emp2 = new Employee(2l, "Priya", 44333.33);
		Employee emp4 = new Employee(20l, "Priya", 24333.33);
		Employee emp3 = new Employee(4l, "Arun", 54433.33);
		
		// HashSet - unordered
		// LinkedHashSet - ordered by insertion
		// TreeSet - sorted
		Set<Employee> employees = new TreeSet<>();
		
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);
		employees.add(emp4);
		employees.add(new Employee(44l, "Shweta", 34543.4));
		
		boolean result = employees.contains(new Employee(4l, "Arun", 54433.33));
		
		System.out.println(new Employee(4l, "Arun", 54433.33).equals(emp3) );
		
		System.out.println(result);
		System.out.println(employees);
		
		
		for(Employee emp: employees){
			if(emp.id == 44l){
				System.out.println(emp);
			}
		}
	}

}
