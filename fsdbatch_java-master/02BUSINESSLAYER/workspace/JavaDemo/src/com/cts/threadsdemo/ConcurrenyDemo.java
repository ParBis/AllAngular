package com.cts.threadsdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ConcurrenyDemo {
	
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
		//Pre -created thread pool
//		ExecutorService service = Executors.newFixedThreadPool(2);
//		First 2 - served by minimum threads
//		Next 1 - Parked in the Queue
//		Last 2 - Thread counts will be incremented 
		
//		Min Threads: 2
//		Queue Size : 2
//		Max Threads: 5
//		5 items
		
//		First 2 - served by minimum threads
//		Next 2 - Parked in the Queue
//		Last 1 - Thread counts will be incremented 
		
		
		
		
		ExecutorService service = new ThreadPoolExecutor(2, 2,
                0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(2), new MyRejectedExecutionHandler());
		
		long startTime = System.currentTimeMillis();
		Callable<Double> task= null;
		List<Future> futures = new ArrayList<>();
		for(Employee emp: employees){
//			service.submit(new MyRunnable(emp));
			task = new MyCallable(emp);
		
			Future<Double> resultOfThread = service.submit(task);
			futures.add(resultOfThread);
			
		}
		
		for(Future<Double> future: futures){
			try {
				Double result = future.get();
				System.out.println("Thread return value:" + result);
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
		
		long endTime = System.currentTimeMillis();
//		service.awaitTermination(3, TimeUnit.SECONDS);
//		boolean result = service.isShutdown();
	
		
		
		System.out.println("Task finished in : " + (endTime - startTime) + " ms");


		service.shutdown();
	}
	

}
