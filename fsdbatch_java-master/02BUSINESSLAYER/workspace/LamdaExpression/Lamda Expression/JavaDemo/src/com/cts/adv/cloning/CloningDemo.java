package com.cts.adv.cloning;

public class CloningDemo {

	 

	public static void main(String[] args) {
		Address address = new Address(343, "GK", "Delhi");
		Employee emp = new Employee(223l, "Ravi", 23433.4, address);
		Employee clonedEmp = null;
		try {
			clonedEmp = emp.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(emp);
		System.out.println(clonedEmp);
		
		System.out.println(emp == clonedEmp);
		
		System.out.println(emp.getAddress());
		System.out.println(clonedEmp.getAddress());
		System.out.println(emp.getAddress() == clonedEmp.getAddress());
		
		
		
//		emp.setAddress(clonedAddress);
//		
//		System.out.println(emp.getAddress() == clonedAddress);
	}
}
