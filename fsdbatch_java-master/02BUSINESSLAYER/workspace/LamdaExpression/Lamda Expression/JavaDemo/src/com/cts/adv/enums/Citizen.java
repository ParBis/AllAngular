package com.cts.adv.enums;

import java.util.EnumSet;

public enum Citizen {
	
	CHILD,ADULT,SENIOR_CITIZEN;


	public static void main(String[] args) {
		String input = "adult";
		
		Citizen citizen = Citizen.valueOf(input.toUpperCase());
		
		switch(citizen){
		case CHILD: System.out.println("from 0 -18"); break;
		case ADULT:System.out.println("from 19 -60"); break;
		case SENIOR_CITIZEN: System.out.println("from 61 -100"); break;
		}
		
		EnumSet<Citizen> allowedInRides = EnumSet.range(CHILD, ADULT);
		System.out.println(allowedInRides);
		
		
	}

}
