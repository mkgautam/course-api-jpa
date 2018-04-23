package com.course_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course_api.model.Course;
import com.course_api.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public List<Course> getAllCourse(String topicId) {
		return courseRepository.getAllCourse(topicId);
	}

	@Override
	public Course getCourse(String id) {
		return courseRepository.getCourse(id);
	}

	@Override
	public void addCourse(Course course) {
		courseRepository.addCourse(course);
	}

	@Override
	public void updateCourse(Course course) {
		courseRepository.updateCourse(course);
	}

	@Override
	public void deleteCourse(String id) {
		courseRepository.deleteCourse(id);
	}

}
