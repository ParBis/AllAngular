package com.cts.exceptionsdemo;

import java.util.ArrayList;
import java.util.List;

public class StringsDemo {
	
	public static void m1(){
//		m1();
	}
	
	public static void main(String[] args) throws InterruptedException {
//		m1();
		String str = new String("");
		List<String> saveRefs = new ArrayList<>();
		for(int i=0;i<1000000000;i++){
			str += i; 
			Thread.sleep(20);
			saveRefs.add(str);
//			str.append(i);
		}
		
		System.out.println(str);
		
	}

}
