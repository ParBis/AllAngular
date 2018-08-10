package com.cts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsDemo {
	
	public static void main(String[] args) {
		Employee emp1 = new Employee(1l, "Ravi", 34433.33);
		Employee emp2 = new Employee(2l, "Priya", 44333.33);
		Employee emp4 = new Employee(20l, "Priya", 24333.33);
		Employee emp3 = new Employee(4l, "Arun", 54433.33);
		
		List<Employee> employees = new ArrayList<>();
//		Employee employees[] = {emp1, emp2, emp3};
//		employees[3] = 
		
//		employees.add(233);
		employees.add(emp1);
		employees.add(0, emp2);
		employees.add(emp3);
		employees.add(emp4);
		employees.add(new Employee(44l, "Shweta", 34543.4));
		
//		System.out.println(employees.get(3));
		
//		Base address: 2000, 2*30+2000 = 2060
		
		Collections.sort(employees, new Comparator<Employee>(){

			@Override
			public int compare(Employee o1, Employee o2) {
				// TODO Auto-generated method stub
				return o2.salary.compareTo(o1.salary);
			}
			
		});
		
		for(Employee e: employees){
			System.out.println(e);
		}
		
		
		List<String> fruits = new ArrayList<>();
		fruits.add("Mango");
		fruits.add("Pineapple");
		fruits.add("Apple");
		
		System.out.println(fruits);
		
		Collections.sort(fruits);
		
		System.out.println(fruits);
		
//		System.out.println(emp.toString());
	}

}
