package com.springrest.springrest.entities;

import javax.persistence.Entity;
import javax.persistence.Id;




@Entity
public class Course {
     @Id
	 private long id;
	 private String title;
	 private String description;
	/**
	 * @param id
	 * @param title
	 * @param description
	 */
	public Course(long id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}
	/**
	 * 
	 */
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
		
	}
	 @Override
	 public String toString() {
         //System.out.println("Course[id=" + id + ", title=" + title + ", description= " + description + "  ]");	
		// System.out.println("hello");
		 return "Course id=" + id + "title=" + title + " description= " + description ;
	 }
	 
}
