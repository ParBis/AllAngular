package com.cts.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name="findBySubId", query="select e from Subject e where e.subjectId = :subjectId")
public class Subject {
	
	public Subject(){}

	public Subject(String subtitle, int durationInHours) {
		super();
		this.subtitle = subtitle;
		this.durationInHours = durationInHours;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int subjectId;
	
	String subtitle; // subjectId
	int durationInHours;
	

	
	//@OneToMany(cascade=CascadeType.ALL)
	@OneToMany(cascade=CascadeType.ALL, mappedBy="subject")
	Set<Book> books;
	
	/**
	 * @return the subjectId
	 */
	public int getSubjectId() {
		return subjectId;
	}

	/**
	 * @param subjectId the subjectId to set
	 */
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	/**
	 * @return the subtitle
	 */
	public String getSubtitle() {
		return subtitle;
	}

	/**
	 * @param subtitle the subtitle to set
	 */
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	/**
	 * @return the durationInHours
	 */
	public int getDurationInHours() {
		return durationInHours;
	}

	/**
	 * @param durationInHours the durationInHours to set
	 */
	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}

	
		
	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subtitle=" + subtitle + ", durationInHours=" + durationInHours
				/*+ ", books=" + books + "]"*/;
	}

	
	
	
	
	
	
	
}
