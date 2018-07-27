package com.cts;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cts.entity.Book;
import com.cts.repository.BookRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestBookJpaNamedQuery {

	@Autowired
	BookRepository repo;
	
	@Test
	public void testInsertingBook() {
		Book book = new Book();
		book.setPrice(20000d);
		book.setVolume(1);
		
		String startDate="12-31-2014";
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
		java.util.Date date;
		try {
			date = sdf1.parse(startDate);
			java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 
			book.setPublishDate(sqlStartDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		repo.addBook(book);
	}
	
//	@Test
	public void testFindingBookById() {
		Book book = repo.findById(5);
		assertEquals("should return One Book Details-->", book.getTitle(), "AI");
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
