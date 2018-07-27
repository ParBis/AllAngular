package com.cts.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.entity.Book;
import com.cts.entity.Employee;
import com.cts.repository.SubjectRepo;
import com.cts.repository.EmployeeRepository;
import com.cts.entity.Subject;

@Controller
public class SubBookController {
	
	@Autowired
	SubjectRepo repoSubject;

	// DELETE START //
	@Autowired
	EmployeeRepository repository;
	@RequestMapping(path="/employees", method=RequestMethod.GET)
	public String fetchEmployees(Model model){
		List<Employee> employees = repository.findEmployees();
		System.out.println("Employees the controller");
		System.out.println(employees);
		model.addAttribute("employees", employees);
		return "employees";
	}
	
	@RequestMapping(path="/employee", method=RequestMethod.POST)
	public String addEmployees(Model model,  @RequestParam(value="name", required=true) String name, 
	    @RequestParam(value="salary", required=false) Double salary){
		Employee employee = new Employee(name, salary);
		repository.addEmployee(employee);
		model.addAttribute("message", "Successfully added, " + employee.getName());
		return "redirect:/employees";
	}
	
	// DELETE END //
	
	
	@RequestMapping(path="/subjects", method=RequestMethod.GET)
	public String findSubjects(Model model){
		List<Subject> subjects = repoSubject.findSubjects();
		System.out.println("Subject the controller");
		System.out.println(subjects);
		model.addAttribute("subjectList", subjects);
		return "subjects";
	}

	@RequestMapping(path="/books", method=RequestMethod.GET)
	public String findBooks(Model model){
		List<Book> books = repoSubject.findBooks();
		System.out.println("Book the controller");
		//System.out.println(books);
		for (Book book : books) {
			System.out.println(book);
			System.out.println(book.getSubject());
		}
		model.addAttribute("bookList", books);
		return "books";
	}

	@RequestMapping(path="/subject", method=RequestMethod.POST)
	public String addbook(Model model,  @RequestParam(value="subtitle", required=true) String subtitle,
			@RequestParam(value="durationInHours", required=true) int durationInHours,
			@RequestParam(value="title", required=true) String title,
			@RequestParam(value="price", required=true) Double price,
			@RequestParam(value="volume", required=true) int volume,
			@RequestParam(value="publishDate", required=true) Date publishDate){
		
		Subject subject = new Subject(subtitle, durationInHours);
		Book book1 = new Book(title, price, volume, publishDate);
		book1.setSubject(subject);
		/*Book book2 = new Book("HistBook", 200, 1, sqlStartDate);
		book2.setSubject(subject);*/
		Set<Book> books = new HashSet<>();
		books.add(book1); 
		/*books.add(book2);*/
		
		subject.setBooks(books);
		
		repoSubject.addSubject(subject);
		model.addAttribute("message", "Successfully added, " + subject.getSubtitle());
		return "redirect:/books";
	}
	
	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public String findBook(Model model, @PathVariable("id") String argBookId) {
		int intargBookId = Integer.parseInt(argBookId);
		List<Book> books = repoSubject.findBook(intargBookId);
		Book book = null;
		if(books.size() > 0) {
			book = books.get(0);
		}
		/*for (Book bookLoop : books) {
			book = bookLoop;
			System.out.println(book);
			System.out.println(book.getSubject());
		}*/
		model.addAttribute("subtitle", book.getSubject().getSubtitle());
		model.addAttribute("durationInHours", book.getSubject().getDurationInHours());
		model.addAttribute("title", book.getTitle());
		model.addAttribute("price", book.getPrice());
		model.addAttribute("volume", book.getVolume());
		model.addAttribute("publishDate", book.getPublishDate());
		model.addAttribute("bookId", book.getBookId());
		model.addAttribute("subjectId", book.getSubject().getSubjectId());
		//model.addAttribute("bookList", books);
		model.addAttribute("message", "edit");
		return "subjectBookInsert";
    }

	@RequestMapping(path="/openAddBooks", method=RequestMethod.GET)
	public String openAddBooks(Model model){
		model.addAttribute("message", "add");
		return "subjectBookInsert";
	}
	
	@RequestMapping(value = "/removeBook/{id}", method = RequestMethod.GET)
    public String removeBook(Model model, @PathVariable("id") String argBookId) {
		int intargBookId = Integer.parseInt(argBookId);
		repoSubject.removeBook(intargBookId);
		model.addAttribute("message", "Successfully deleted book Id: , " + argBookId);
		return "redirect:/books";
    }

	

	@RequestMapping(value="/updatesubject", method=RequestMethod.GET)
	public String updatebook(Model model,  
			@RequestParam(value="subtitle", required=true) String subtitle,
			@RequestParam(value="durationInHours", required=true) int durationInHours,
			@RequestParam(value="title", required=true) String title,
			@RequestParam(value="price", required=true) Double price,
			@RequestParam(value="volume", required=true) int volume,
			@RequestParam(value="publishDate", required=true) Date publishDate,
			@RequestParam(value="bookId", required=true) int bookId,
			@RequestParam(value="subjectId", required=true) int subjectId){
		
		System.out.println(subjectId+"In updatesubject------------------->"+subtitle);
		Subject subject = new Subject(subtitle, durationInHours);
		subject.setSubjectId(subjectId);
		Book book1 = new Book(title, price, volume, publishDate);
		book1.setBookId(bookId);
		book1.setSubject(subject);
		/*Book book2 = new Book("HistBook", 200, 1, sqlStartDate);
		book2.setSubject(subject);*/
		Set<Book> books = new HashSet<>();
		books.add(book1); 
		/*books.add(book2);*/
		
		subject.setBooks(books);
		
		repoSubject.updateBook(subject, bookId);
		model.addAttribute("message", "Successfully updated, " + subject.getSubtitle());
		return "redirect:/books";
	}
	
	
}
