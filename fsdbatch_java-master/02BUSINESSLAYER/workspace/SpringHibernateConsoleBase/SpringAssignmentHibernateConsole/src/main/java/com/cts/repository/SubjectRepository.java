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
public class SubjectRepository {

	static SessionFactory sessionFactory;
	static {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	@Override
	protected void finalize(){
		HibernateUtil.closeSessionFactory();
	}
	

	public void addSubject(Subject subject) {
		// Physical connection to perform db operations
		Session session = sessionFactory.openSession();

		// Manual transactions
		Transaction tx = session.beginTransaction();
		session.save(subject);
		System.out.println(subject + " Subject added to Database!!!");

		tx.commit();
		session.close();
		
	}
	
	public Subject findSubject(int subjectId) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Subject subject = session.get(Subject.class, subjectId);
		System.out.println("Subject Details--> "+subject);
		
		tx.commit();
		session.close();
		return subject;
	}

	public Book findBook(int bookId) {
		
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

	public void removeSubject(int subjectId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Subject subject = session.get(Subject.class, subjectId);
		session.remove(subject);
		System.out.println(subjectId + " Subject removed from Database!!!");
		
		tx.commit();
		session.close();
	}
	
	


	public  List<Subject> findSubjectsOrderByTitle() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Subject> subjects = null;
		
		Query queryResult = session.createNamedQuery("findSubjectsOrderBySubTitle", Subject.class);
		subjects = queryResult.list();
		for (int i = 0; i < subjects.size(); i++) {
			Subject subject = (Subject) subjects.get(i);
			System.out.println(i + 1 + ":: " + subject);
		}
		
		tx.commit();
		session.close();
		return subjects;
	}
		
	public List<Book> findBooksOrderByTitle() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Book> books = null;
				
		Query queryResult = session.createNamedQuery("findBooksOrderByTitle", Book.class);
		books = queryResult.list();
//		System.out.println(books);
		for (int i = 0; i < books.size(); i++) {
		   Book book = (Book) books.get(i);
			System.out.println(i + 1 + ":: " + book);
		}
		
		tx.commit();
		session.close();
		return books;
			
		
	}
	
	public List<Book> findBooksOrderByPublishDate() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Book> books = null;
				
		Query queryResult = session.createNamedQuery("findBooksOrderByPublishDate", Book.class);
		books = queryResult.list();
//		System.out.println(books);
		for (int i = 0; i < books.size(); i++) {
		   Book book = (Book) books.get(i);
			System.out.println(i + 1 + ":: " + book);
		}
		
		tx.commit();
		session.close();
		return books;
			
		
	}

	

}
