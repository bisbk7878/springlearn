package com.springrest.springrest.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course_tbl")
public class Course {
  @Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", descrip=" + descrip + "]";
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
	public String getdescrip() {
		return descrip;
	}
	public void setdescrip(String descrip) {
		this.descrip = descrip;
	}
public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
public Course(long id, String title, String descrip) {
		super();
		this.id = id;
		this.title = title;
		this.descrip = descrip;
	}
   @Id
  private long id;
  private String title;
  private String descrip;
}
