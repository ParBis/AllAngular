package com.cts;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;


public class MapsDemo {

	public static void main(String[] args) {
		Map<Long, Employee> employeeMap = new TreeMap<>();
		
		Employee emp1 = new Employee(1l, "Ravi", 34433.33);
		Employee emp2 = new Employee(2l, "Priya", 44333.33);
		Employee emp4 = new Employee(20l, "Priya", 24333.33);
		Employee emp3 = new Employee(4l, "Arun", 54433.33);
		
		employeeMap.put(1L, emp1);
		employeeMap.put(2L, emp2);
		employeeMap.put(20L, emp3);
		employeeMap.put(4L, emp4);
		
		employeeMap.put(44l, new Employee(44l, "Shweta", 34543.4));
		
//		System.out.println(employeeMap.get(44l));
		
//		System.out.println(employeeMap);
		
		Set<Entry<Long, Employee>> mySet = employeeMap.entrySet();
		System.out.println(mySet);
		
		for(Entry<Long, Employee> entry: mySet){
			System.out.println(entry);
		}
//		
//		for(Long key: employeeMap.keySet()){
//			System.out.println(employeeMap.get(key));
//		}
		
		
		

	}

}
