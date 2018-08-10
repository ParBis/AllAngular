package com.cts.threadsdemo;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Double> {

	Employee emp;
	public MyCallable(Employee emp) {
		this.emp = emp;
	}
	
	@Override
	public Double call() throws Exception {
		System.out.println("task run by" + Thread.currentThread().getName());
		try {
			emp.increment(5000);
			System.out.println("Inremented: " + emp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			return false;
		}
		return emp.salary;
	}

	

}
