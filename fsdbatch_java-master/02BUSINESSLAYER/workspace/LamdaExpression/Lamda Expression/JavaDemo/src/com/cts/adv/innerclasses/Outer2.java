package com.cts.adv.innerclasses;

public class Outer2 {
	
	public Outer2(int id) {
		super();
		this.id = id;
	}

	int id;
	
	class Inner{
		
		public void displayId(){
			System.out.println(id);
		}
	}

}
