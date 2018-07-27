package com.cts;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.cts.entity.Book;
import com.cts.entity.Subject;
import com.cts.repository.SubjectRepository;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class SubBookHibernateNavigation {

	@Autowired
	SubjectRepository repo;
	
//	@Test
	public void testInsertingBook() {
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

		Book book1 = new Book("GKBook", 100, 1, sqlStartDate);
		Book book2 = new Book("HistBook", 200, 1, sqlStartDate);
		Set<Book> books = new HashSet<>();
		books.add(book1); 
		books.add(book2);
		
		Subject subject = new Subject("Arts", 5);
		
		//subject.setName("Lini");
		subject.setBooks(books);
		repo.addSubject(subject);
		//emp1.setName("ABCD");

		
	}
	
//	@Test
	public void testFindingSubjectById(int id) {
		Subject subject = repo.findSubject(id);
		//System.out.println(subject.getBooks());
	}

//	@Test
	public void testFindingBookById(int id) {
		Book book = repo.findBook(id);
		//System.out.println(subject.getBooks());
	}
	
//	@Test
	public void testRemovingSubject(int id) {
		repo.removeSubject(id);
	}


//	@Test
	public void testRemovingBook(int id) {
		repo.removeBook(id);
	}
	
	
	/*
	@Test
	public void testUpdatingEmployeeSalary() {
		repo.updateEmployee(1, 30000d);
	}
	*/
	

	public void findBooksOrderByTitle() {
		repo.findBooksOrderByTitle();
		//System.out.println(subject.getBooks());
	}
	public void findBooksOrderByPublishDate() {
		repo.findBooksOrderByPublishDate();
		//System.out.println(subject.getBooks());
	}

	public void findSubjectsOrderByTitle() {
		repo.findSubjectsOrderByTitle();
		//System.out.println(subject.getBooks());
	}

}
