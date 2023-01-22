package com.springBootRest.springBoot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBootRest.springBoot.entities.Course;

public interface CourseDao extends JpaRepository<Course, Long>{
	
  	void deleteByTitle(String title);

}
