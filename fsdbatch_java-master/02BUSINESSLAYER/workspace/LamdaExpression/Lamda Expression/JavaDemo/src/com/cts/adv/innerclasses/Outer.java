package com.cts.adv.innerclasses;

public class Outer {
	
	public Outer(int id) {
		super();
		this.id = id;
	}

	int id;
	static int count =3;
	
	static class Inner{
		
		public void displayId(){
			System.out.println(count);
		}
	}

}
