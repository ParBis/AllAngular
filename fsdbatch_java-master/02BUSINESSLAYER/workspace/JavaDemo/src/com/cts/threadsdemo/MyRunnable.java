package com.cts.threadsdemo;

public class MyRunnable implements Runnable {

	Employee emp;
	public MyRunnable(Employee emp) {
		this.emp = emp;
	}

	@Override
	public void run() {
		System.out.println("task run by" + Thread.currentThread().getName());
//		try {
//			emp.increment(5000);
//			System.out.println("Inremented: " + emp);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

}
