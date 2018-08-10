package com.cts.finalproject;

import java.util.Date;

public class Category {
	
	String categoryName;
	Date categoryDt;
	public Category(){
		
	}
	
	public Category(String categoryName, Date categoryDt) {
		super();
		this.categoryName = categoryName;
		this.categoryDt = categoryDt;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Date getCategoryDt() {
		return categoryDt;
	}
	public void setCategoryDt(Date categoryDt) {
		this.categoryDt = categoryDt;
	}
	@Override
	public String toString() {
		return "Category [categoryName=" + categoryName + ", categoryDt=" + categoryDt + "]";
	}
	
	

}
