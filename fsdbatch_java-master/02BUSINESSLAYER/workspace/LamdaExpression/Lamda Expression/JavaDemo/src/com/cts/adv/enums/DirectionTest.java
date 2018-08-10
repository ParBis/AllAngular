package com.cts.adv.enums;

import java.util.ArrayList;
import java.util.List;

public class DirectionTest {

	
	public enum Directions {
		NORTH("N"), SOUTH("S"), EAST("E"), WEST("W");
		
		private String value;
		private Directions(String value){
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		
	}
	
	public static void main(String[] args) {
		List<String> directionsList = new ArrayList<>();
		for(Directions d: Directions.values()){
			System.out.println(d.getValue());
			directionsList.add(d.toString());
		}
		
		for(String obj: directionsList){
			System.out.println(obj);
		}
		
		// INput
		String str1 = new String("NORTH");
		String str2 = new String("SOUTH");
		
		Directions north = Directions.valueOf(str1);
		Directions north2 = Directions.valueOf(str2);
		
		if(north == north2){
			System.out.println("Same directions");
		}
	}
	
	
}
