package com.cts;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class QueuesDemo {
	
	public static void main(String[] args) {
		
		Employee emp1 = new Employee(1l, "Ravi", 34433.33);
		Employee emp2 = new Employee(2l, "Priya", 44333.33);
		Employee emp4 = new Employee(20l, "Priya", 24333.33);
		Employee emp3 = new Employee(4l, "Arun", 54433.33);
		Queue<Employee> q = new PriorityQueue<>();
	
		q.add(emp4);
		q.add(emp2);
		q.add(emp1);
		
		System.out.println(q.peek());
		System.out.println(q);
		
		BlockingQueue<Employee> employeeQueue = new ArrayBlockingQueue<>(2);
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				
				try {
					Thread.currentThread().sleep(5000);
					System.out.println(employeeQueue.take());
					System.out.println(employeeQueue.take());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}).start();
		
		
		try {
			
			
			employeeQueue.put(emp4);
			System.out.println("Added");
			employeeQueue.put(emp2);
			System.out.println("Added");
			employeeQueue.put(emp1);
			System.out.println("Added");
			employeeQueue.put(emp3);
			System.out.println("Added");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(employeeQueue);
		
	}

}
