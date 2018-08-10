package com.cts.finalproject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin("*")
public class CategoryController {

	@RequestMapping(value="/categories")
	public List<Category> fetchCategories(){
		Category cat1 = new Category("Jogging", new Date());
		Category cat2 = new Category("Swimming", new Date());
		List<Category> categories = new ArrayList<>();
		categories.add(cat1); categories.add(cat2);
		return categories;
	}
	
}
