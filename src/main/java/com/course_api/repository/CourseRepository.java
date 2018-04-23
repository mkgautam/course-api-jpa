package com.course_api.repository;

import java.util.List;

import com.course_api.model.Course;

public interface CourseRepository {

	List<Course> getAllCourse(String topicId);

	void addCourse(Course course);

	Course getCourse(String id);

	void deleteCourse(String id);

	void updateCourse(Course course);

}
