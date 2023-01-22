package com.springBootRest.springBoot.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBootRest.springBoot.dao.CourseDao;
import com.springBootRest.springBoot.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;
	
	
	List<Course> list;

	@Override
	public List<Course> getAllCourses() {
		return courseDao.findAll();
		//return list;
	}

	@Override
	public Course getCourse(long courseId) {
      Optional<Course> c = courseDao.findById(courseId);
	return c.isPresent()?c.get():null;
	}

	@Override
	public Course addCourse(Course course) {
		//list.add(course);
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
//		list.forEach(e -> {
//			if(e.getId() == course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDesc(course.getDesc());
//			}
//		});
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
		courseDao.deleteById(parseLong);
	}
	
	@Override
	public boolean deleteCourseByTitle(String parseLong) {
				courseDao.deleteByTitle(parseLong);
				return true;
	}

	

}
