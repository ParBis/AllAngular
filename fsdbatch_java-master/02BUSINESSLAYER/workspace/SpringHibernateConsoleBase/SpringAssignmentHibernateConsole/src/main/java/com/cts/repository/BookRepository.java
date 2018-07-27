package com.cts.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.cts.entity.Book;
import com.cts.entity.Subject;

@Repository
public class BookRepository {

	static SessionFactory sessionFactory;
	static {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	@Override
	protected void finalize(){
		HibernateUtil.closeSessionFactory();
	}


	public void addBook(Book book) {
		// Physical connection to perform db operations
		Session session = sessionFactory.openSession();

		// Manual transactions
		Transaction tx = session.beginTransaction();
		session.save(book);
		System.out.println(book + " Book added to Database!!!");

		tx.commit();
		session.close();
		
	}


	public Book findById(int bookId) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Book book = session.get(Book.class, bookId);
		System.out.println("Book Details--> "+book);
		
		tx.commit();
		session.close();
		return book;
	}
	
	public void removeBook(int bookId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Book book = session.get(Book.class, bookId);
		session.remove(book);
		System.out.println(bookId + " Book removed from Database!!!");
		
		tx.commit();
		session.close();
	}

	

}
