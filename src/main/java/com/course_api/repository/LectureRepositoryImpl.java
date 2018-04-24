package com.course_api.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.course_api.model.Lecture;

@Repository
public class LectureRepositoryImpl implements LectureRepository{
	
	@Autowired
	private Lecture_CrudRepositoryImpl lectureCrudRepositoryImpl;

	@Override
	public List<Lecture> getAllLecture(String courseId) {
		List<Lecture> lectures = new ArrayList<>();
		for (Lecture course : lectureCrudRepositoryImpl.findByCourseId(courseId)) {
			lectures.add(course);
		}
		return lectures;
	}

	@Override
	public Lecture getLecture(String lectureId) {
		Optional<Lecture> lectureOptional = lectureCrudRepositoryImpl.findById(lectureId);
		if (lectureOptional.isPresent()) {
			return lectureOptional.get();
		} else {
			return new Lecture();
		}
	}

	@Override
	public void addLecture(Lecture lecture) {
		lectureCrudRepositoryImpl.save(lecture);
	}

	@Override
	public void updateLecture(Lecture lecture) {
		lectureCrudRepositoryImpl.save(lecture);
	}

	@Override
	public void deleteLecture(String lectureId) {
		lectureCrudRepositoryImpl.deleteById(lectureId);
	}

}
