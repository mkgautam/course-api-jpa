package com.course_api.repository;

import java.util.List;

import com.course_api.model.Lecture;

public interface LectureRepository {

	List<Lecture> getAllLecture(String courseId);
	Lecture getLecture(String lectureId);
	void addLecture(Lecture lecture);
	void updateLecture(Lecture lecture);
	void deleteLecture(String lectureId);

}
