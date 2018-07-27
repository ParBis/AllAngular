package com.cts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("classpath:beans.xml")
public class TestSubBookJpaMain {

	
	public static void main(String[] args) throws IOException {
		BufferedReader standardInput = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Welcome to console based Spring Application!!!");
		System.out.println("Please select your choice from below:");
		System.out.println("1: Add Subject; 2: Delete Subject; 3: Delete Book; 4: Search for a Book; 5: Search for a Subject; 6: Exit");
		
		System.out.print("Enter your choice: ");
		String choice = standardInput.readLine();
		System.out.println("Hello " + choice);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		TestSubBookJpaNavigation te = (TestSubBookJpaNavigation) context.getBean("testSubBookJpaNavigation");
		

		if(null != choice && "1".equals(choice)) {
			te.testInsertingBook();
		}
		else if(null != choice && "2".equals(choice)) {
			System.out.print("Enter Subject ID: ");
			int id = Integer.valueOf(standardInput.readLine());
			te.testRemovingSubject(id);
		}
		else if(null != choice && "3".equals(choice)) {
			System.out.print("Enter Book ID: ");
			int id = Integer.valueOf(standardInput.readLine());
			te.testRemovingBook(id);
		}
		else if(null != choice && "4".equals(choice)) {
			System.out.print("Enter Book ID: ");
			int id = Integer.valueOf(standardInput.readLine());
			te.testFindingBookById(id);
		}
		else if(null != choice && "5".equals(choice)) {
			System.out.print("Enter Subject ID: ");
			int id = Integer.valueOf(standardInput.readLine());
			te.testFindingSubjectById(id);
		}
		else if(null != choice && "6".equals(choice)) {
		    System.exit(1);
		}
		else {
			System.out.println("Invalid Choice!!!");
		}
		

	}

}
