package com.course_api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.course_api.model.Lecture;

public interface Lecture_CrudRepositoryImpl extends CrudRepository<Lecture, String> {
	
	public List<Lecture> findByCourseId(String courseId);
	
}
