package com.springBootRest.springBoot.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springBootRest.springBoot.entities.Course;
import com.springBootRest.springBoot.services.CourseService;

@RestController
public class AppController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/home")
	public String home(){
		return "You are on home page.";
	}
	
	@GetMapping("/courses")
	public List<Course> getAllCourses(){
		return this.courseService.getAllCourses();
	}
	
	@GetMapping("/courses/{cid}")
	public Course getCourse(@PathVariable String cid){
		Course c = this.courseService.getCourse(Long.parseLong(cid));
     return Objects.nonNull(c)?c:null;
	}
	
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}
	
	@PutMapping("/courses/{cid}")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
	}
	
	@DeleteMapping("/courses/{cid}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String cid){
		try {
			this.courseService.deleteCourse(Long.parseLong(cid));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/courses/title/{title}")
	public ResponseEntity deleteCourseByTitle(@PathVariable String title){
		try {
			this.courseService.deleteCourseByTitle(title);
			ResponseEntity rs = new ResponseEntity(HttpStatus.OK);
			return rs;
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
