package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

@RestController//(it tells that it is rest webservice)
public class MyController {
	@Autowired //( make object during runtime)
	private CourseService courseService;
	@GetMapping("/home")
   public String home() {
	   return "I Welcome You!!!!!";
   }
	//get the courses
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return this.courseService.getCourses();
	}
	
	@GetMapping("/courses/{Cid}")
	public Course getCourse(@PathVariable String Cid) {
		return this.courseService.getCourse(Long.parseLong(Cid));
	}
	@PostMapping("/courses")
	public Course addcourse(@RequestBody Course course)
	{
	  return this.courseService.addCourse(course);
		
	}

	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
		
	}
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String Cid ){
		try {
			this.courseService.deleteCourse(Long.parseLong(Cid));
			return new ResponseEntity<>(HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
}
