package com.course_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course_api.model.Lecture;
import com.course_api.repository.LectureRepository;

@Service
public class LectureServiceImpl implements LectureService {
	
	@Autowired
	private LectureRepository lectureRepository;

	@Override
	public List<Lecture> getAllLecture(String courseId) {
		return lectureRepository.getAllLecture(courseId);
	}

	@Override
	public Lecture getLecture(String lectureId) {
		return lectureRepository.getLecture(lectureId);
	}

	@Override
	public void addLecture(Lecture lecture) {
		lectureRepository.addLecture(lecture);
	}

	@Override
	public void updateLecture(Lecture lecture) {
		lectureRepository.updateLecture(lecture);
	}

	@Override
	public void deleteLecture(String lectureId) {
		lectureRepository.deleteLecture(lectureId);
	}

}
