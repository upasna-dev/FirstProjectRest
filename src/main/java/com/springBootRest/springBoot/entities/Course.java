package com.springBootRest.springBoot.entities;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Course {
	
	@Id
	private long id;
	private String title;
	private String description;
	
	
	public Course() {
		super();
	}
	
	public Course(long id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", description=" + description + "]";
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getdescription() {
		return description;
	}
	public void setdescription(String description) {
		this.description = description;
	}
	
	

}
