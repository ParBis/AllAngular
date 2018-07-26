package com.cts.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.entity.Book;
import com.cts.entity.Employee;
import com.cts.entity.Subject;

@Repository
public class SubjectRepo {
	static SessionFactory sessionFactory;

	/*static {
		sessionFactory = HibernateUtil.getSessionFactory();
	}*/

	@PersistenceContext
	EntityManager em;

	
	/*public void addSubject(Subject sub) {
		// Physical connection to perform db operations
		Session session = sessionFactory.openSession();

		// Manual transactions
		Transaction tx = session.beginTransaction();
		session.save(sub);
		
		//

		tx.commit();
		session.close();
		
	}
	
	@Override
	protected void finalize(){
		HibernateUtil.closeSessionFactory();
	}

	

	public Subject findSubject(int id) {
		// Physical connection to perform db operations
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Subject sub = session.get(Subject.class, id);
		
		Set<Book> books = sub.getBooks();
		System.out.println(books);
		
		
		//Persistent state
		for(Book book: books){
			Subject e = book.getSubject();
			e.setSubtitle("Bengali");
		}
		
		tx.commit();
		session.close();
		return sub;
	}*/
	

	public  List<Subject> findSubjects() {
		TypedQuery<Subject> query = em.createNamedQuery("findSubjects", Subject.class);
		List<Subject> subjects = query.getResultList();
		//System.out.println(subjects);
		return subjects;
	}
	public  List<Book> findBooks() {
		TypedQuery<Book> query = em.createNamedQuery("findBooks", Book.class);
		List<Book> books = query.getResultList();
		//System.out.println(books);
		return books;
	}

	@Transactional
	public void addSubject(Subject subject) {
		em.persist(subject);
	}
	
	public List<Book> findBook(int id) {
		Book book = em.find(Book.class, id);
		/*System.out.println(book);
		System.out.println(book.getSubject());*/
		List<Book> books = new ArrayList();
		books.add(book);
		return books;
	}
	
	@Transactional
	public void removeBook(int id) {
		Book book = em.find(Book.class, id);
		em.remove(book);
	}

	@Transactional
	public void updateBook(Subject newSubject, int intBookId) {
		Book book = em.find(Book.class, intBookId);

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
	}

	
}
