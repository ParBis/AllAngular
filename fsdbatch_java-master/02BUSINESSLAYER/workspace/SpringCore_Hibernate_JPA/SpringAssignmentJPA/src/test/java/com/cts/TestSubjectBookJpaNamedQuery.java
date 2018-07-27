package com.cts;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cts.entity.Book;
import com.cts.entity.Subject;
import com.cts.repository.SubjectRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestSubjectBookJpaNamedQuery {

	@Autowired
	SubjectRepository repo;
	
	@Test
	public void testInsertingBook() {
		/*Subject subject = new Subject("Automata1");
		subject.setDurationInHours(6);
		
		repo.addSubject(subject);*/
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
		
		
		//emp1.setName("ABCD");

		
	}
	
//	@Test
	public void testFindingSubjectById() {
		Subject subject = repo.findSubject(6);
		//System.out.println(subject.getBooks());
		/*Set<Book> books = subject.getBooks();
		for(Book book: books){
			int id = book.getBookId();
			System.out.println(id);
		}*/
	}

//	@Test
	public void testFindingBookById() {
		Book book = repo.findBook(5);
		//System.out.println(subject.getBooks());
	}
	
//	@Test
	public void testRemovingSubject() {
		repo.removeSubject(10);
	}


//	@Test
	public void testRemovingBook() {
		repo.removeBook(5);
	}
	
	
	/*
	@Test
	public void testUpdatingEmployeeSalary() {
		repo.updateEmployee(1, 30000d);
	}
	*/

}
