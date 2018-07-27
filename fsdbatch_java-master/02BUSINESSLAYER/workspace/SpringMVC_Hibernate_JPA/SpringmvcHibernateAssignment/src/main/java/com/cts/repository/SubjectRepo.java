package com.cts.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.entity.Book;
import com.cts.entity.Subject;

@Repository
public class SubjectRepo {
	static SessionFactory sessionFactory;

	static {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	@Override
	protected void finalize(){
		HibernateUtil.closeSessionFactory();
	}

	/*@PersistenceContext
	EntityManager em;*/


	public  List<Subject> findSubjects() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Subject> subjects = null;
		
		Query queryResult = session.createNamedQuery("findSubjects", Subject.class);
		subjects = queryResult.list();
		
		tx.commit();
		session.close();
		return subjects;
	}
		
	public List<Book> findBooks() {
		// Physical connection to perform db operations
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Book> books = null;
				
		Query queryResult = session.createNamedQuery("findBooks", Book.class);
		books = queryResult.list();
		/*System.out.println(books);
		for (int i = 0; i < books.size(); i++) {
		   Book book = (Book) books.get(i);
			System.out.println("Book-->" + book);
		}*/
		
		tx.commit();
		session.close();
		return books;
			
		
	}
	
	@Transactional
	public void removeBook(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Book book = session.get(Book.class, id);
		session.remove(book);
		
		tx.commit();
		session.close();
	}
	
	public List<Book> findBook(int id) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Book> books = new ArrayList();
		
		Book book = session.get(Book.class, id);
		books.add(book);
		
		tx.commit();
		session.close();
		return books;
	}
	
	public void addSubject(Subject subject) {
		// Physical connection to perform db operations
		Session session = sessionFactory.openSession();

		// Manual transactions
		Transaction tx = session.beginTransaction();
		session.save(subject);

		tx.commit();
		session.close();
		
	}
	
	public void updateBook(Subject newSubject, int intBookId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Book book = session.get(Book.class, intBookId);

		Set<Book> newBooks = newSubject.getBooks();
		Subject oldSubject = book.getSubject();
		oldSubject.setSubjectId(newSubject.getSubjectId());
		oldSubject.setSubtitle(newSubject.getSubtitle());
		oldSubject.setDurationInHours(newSubject.getDurationInHours());
		for(Book newBook : newBooks) {
			book.setTitle(newBook.getTitle());
			book.setPrice(newBook.getPrice());
			book.setVolume(newBook.getVolume());
			book.setPublishDate(newBook.getPublishDate());
			book.setSubject(oldSubject);
		}
		
		tx.commit();
		session.close();
	}
	
}
