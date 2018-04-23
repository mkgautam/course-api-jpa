package com.course_api.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.course_api.model.Course;

@Repository
public class CourseRepositoryImpl implements CourseRepository {
	
	@Autowired
	private Course_CrudRepositoryImpl courseCrudRepositoryImpl;

	@Override
	public List<Course> getAllCourse(String topicId) {
		List<Course> courses = new ArrayList<>();
		for (Course course : courseCrudRepositoryImpl.findByTopicId(topicId)) {
			courses.add(course);
		}
		return courses;
	}
	
	@Override
	public Course getCourse(String id) {
		Optional<Course> courseOptional = courseCrudRepositoryImpl.findById(id);
		if (courseOptional.isPresent()) {
			return courseOptional.get();
		} else {
			return new Course();
		}
	}
	
	@Override
	public void addCourse(Course course) {
		try {
			courseCrudRepositoryImpl.save(course);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateCourse(Course course) {
		courseCrudRepositoryImpl.save(course);
	}
	
	@Override
	public void deleteCourse(String id) {
		courseCrudRepositoryImpl.deleteById(id);
	}

}
