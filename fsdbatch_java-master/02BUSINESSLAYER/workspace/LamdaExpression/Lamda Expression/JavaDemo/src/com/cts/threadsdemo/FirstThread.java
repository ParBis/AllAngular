package com.cts.threadsdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class FirstThread {

	public static void main(String[] args) throws InterruptedException {
		Employee emp1 = new Employee(1l, "Ravi", 34433.33);
		Employee emp2 = new Employee(2l, "Priya", 44333.33);
		Employee emp4 = new Employee(20l, "Priya", 24333.33);
		Employee emp3 = new Employee(4l, "Arun", 54433.33);
		
	
		Set<Employee> employees = new TreeSet<>();
		
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);
		employees.add(new Employee(44l, "Shweta", 34543.4));
		
		long startTime = System.currentTimeMillis();
		
		List<Thread> threads = new ArrayList<>();
		for(Employee emp: employees){
			Runnable myRunnable = new MyRunnable(emp); 
			Thread t = new Thread(myRunnable, "t1");
			t.start();
//			t.join();
			threads.add(t);	
		}
		
		for(Thread t: threads){
			t.join();
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("Task finished in : " + (endTime - startTime) + " ms");
//		
//		Runnable myRunnable = new MyRunnable(); 
//		Thread t = new Thread(myRunnable, "t1");
//		t.start();
//		
//		
//		System.out.println("Main task executed by : " + Thread.currentThread().getName());

	}

}
