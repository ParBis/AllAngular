package com.cts.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.entity.Book;

@Repository
public class BookRepository {

	@PersistenceContext
	EntityManager em;

	@Transactional
	public void addBook(Book book) {
		em.persist(book);
	}
	
	public Book findById(int bookId) {
		System.out.println("------>");
		TypedQuery<Book> query = em.createNamedQuery("findByBookId", Book.class);
		query.setParameter("bookId", bookId);
		Book book = query.getSingleResult();
		System.out.println("------>"+book);
		return book;
	}

	@Transactional
	public void removeBook(int bookId) {
		Book emp = em.find(Book.class, bookId);
		em.remove(emp);
	}
	

	/*public void findEmployee(int id) {
		Employee emp = em.find(Employee.class, id);
		System.out.println(emp);
	}

	@Transactional
	public void removeEmployee(int id) {
		Employee emp = em.find(Employee.class, id);
		em.remove(emp);
	}

	@Transactional
	public void updateEmployee(int id, double salary) {
		Employee emp = em.find(Employee.class, id);
		emp.setSalary(salary);
		System.out.println(emp);
	}

	public Employee findByName(String name) {
		System.out.println("------>");
		TypedQuery<Employee> query = em.createNamedQuery("findEmployeeByName", Employee.class);
		query.setParameter("name", name);
		Employee emp = query.getSingleResult();
		System.out.println("------>"+emp);
		return emp;
	}
	

	public List<Employee> findBySalary(double salary) {
		TypedQuery<Employee> query = em.createNamedQuery("findEmployeeBySalary", Employee.class);
		query.setParameter("salary", salary);
		List<Employee> employees = query.getResultList();
		System.out.println("---->"+employees);
		return employees;
	}*/

}
