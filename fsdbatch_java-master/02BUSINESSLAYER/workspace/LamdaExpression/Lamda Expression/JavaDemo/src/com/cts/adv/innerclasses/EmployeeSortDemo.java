package com.cts.adv.innerclasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.cts.adv.cloning.Address;
import com.cts.adv.cloning.Employee;

public class EmployeeSortDemo {
	
	public static void main(String[] args) {
		
		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		Address address = new Address(343, "GK", "Delhi");
		Employee emp = new Employee(223l, "Ravi", 23433.4, address);
		
		Address address2 = new Address(343, "Kalyani", "Pune");
		Employee emp2 = new Employee(23l, "Priya", 22433.4, address2);
		
		employees.add(emp);
		employees.add(emp2);
		
		System.out.println(employees);
		
		Collections.sort(employees, new Comparator<Employee>(){

			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getSalary().compareTo(o2.getSalary());
			}
			
		});
		
		System.out.println(employees);
	}

}
