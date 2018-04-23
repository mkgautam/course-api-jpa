package com.course_api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.course_api.model.Course;

public interface Course_CrudRepositoryImpl extends CrudRepository<Course, String> {
	
	public List<Course> findByTopicId(String topicId);
	
}
