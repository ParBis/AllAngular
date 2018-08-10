package com.cts.adv.annotations;

public class CustomAnnotationsDemo {

	public static void main(String[] args) {
//		Employee emp = new Employee();
		AnnotationsInterpreter interperter = new AnnotationsInterpreter();
		interperter.inject(Employee.class);
	}

}
