package com.springBootRest.springBoot.services;

import java.util.List;

import com.springBootRest.springBoot.entities.Course;

public interface CourseService {
	
	public List<Course> getAllCourses();

	public Course getCourse(long courseId);
	
	public Course addCourse(Course course);

	public Course updateCourse(Course course);

	public void deleteCourse(long parseLong);
	public boolean deleteCourseByTitle(String parseLong);
}
