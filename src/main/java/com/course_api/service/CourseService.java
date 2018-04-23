package com.course_api.service;

import java.util.List;

import com.course_api.model.Course;

public interface CourseService {

	List<Course> getAllCourse(String topicId);
	Course getCourse(String id);
	void addCourse(Course course);
	void updateCourse(Course course);
	void deleteCourse(String id);

}