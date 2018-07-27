package com.cts;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cts.entities.Address;
import com.cts.entities.Employee;
import com.cts.entities.Book;
import com.cts.entities.Subject;
import com.cts.repos.EmployeeRepo;

public class TestSubjectWithBookRepo {

	private EmployeeRepo repo = new EmployeeRepo();

	@BeforeClass
	public static void setUp() {
		// repo.
	}

	// @Test
	public void addEmployee() {
		Address address = new Address("Gk", "Delhi");
		Employee emp1 = new Employee();
		emp1.setName("Sandeep");
		// emp1.setAddress(address);
		repo.addEmployee(emp1);
	}

//	@Test
	public void addEmployeeWithAddresses() {
		Employee emp1 = new Employee();
		emp1.setName("Rahul");
		
		Address address = new Address("Gk", "Delhi");
		address.setEmployee(emp1);
		Address officeAddress = new Address("DLF", "Gurugram");
		officeAddress.setEmployee(emp1);
		Set<Address> addresses = new HashSet<>();
		addresses.add(address); addresses.add(officeAddress);
		
		emp1.setAddresses(addresses);
		// emp1.setAddress(address);
		repo.addEmployee(emp1);
	}
	

	@Test
	public void addSubjectWithBook() {
		String startDate="12-31-2014";
		java.sql.Date sqlStartDate = null;
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
		java.util.Date date;
		try {
			date = sdf1.parse(startDate);
			sqlStartDate = new java.sql.Date(date.getTime()); 
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Subject subject = new Subject("Arts", 5);
		Book book1 = new Book("GKBook", 100, 1, sqlStartDate);
		book1.setSubject(subject);
		Book book2 = new Book("HistBook", 200, 1, sqlStartDate);
		book2.setSubject(subject);
		Set<Book> books = new HashSet<>();
		books.add(book1); 
		books.add(book2);
		
		//subject.setName("Lini");
		subject.setBooks(books);
		repo.addSubject(subject);
	}
	

//	@Test
	public void findEmployee() {
		Employee employee = repo.findEmployee(22);
		System.out.println(employee);
		
//		employee.setName("ZZZZ"); // update
		
		System.out.println(employee.getAddresses());
//		 System.out.println(employee.getAddress());
	}

}
