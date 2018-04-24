package com.course_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.course_api.model.Course;
import com.course_api.model.Lecture;
import com.course_api.model.ResponseText;
import com.course_api.service.LectureService;

@RestController
public class LectureController {
	
	@Autowired
	private LectureService lectureService;
	
	@RequestMapping(value = "/topics/{topicId}/courses/{courseId}/lectures", method = RequestMethod.GET)
	public List<Lecture> getAllLecture (@PathVariable String courseId) {
		return lectureService.getAllLecture(courseId);
	}
	
	@RequestMapping(value = "/topics/{topicId}/courses/{courseId}/lectures/{lectureId}", method = RequestMethod.GET)
	public Lecture getLecture (@PathVariable String lectureId) {
		return lectureService.getLecture(lectureId);
	}
	
	@RequestMapping(value = "/topics/{topicId}/courses/{courseId}/lectures", method = RequestMethod.POST)
	public ResponseText addLecture (@RequestBody Lecture lecture, @PathVariable String courseId, @PathVariable String topicId) {
		ResponseText responseText = new ResponseText();
		try {
			lecture.setCourse(new Course(courseId, "", "", topicId));
			lectureService.addLecture(lecture);
			responseText.setResponse("Success");
		} catch (Exception e) {
			responseText.setResponse("Failure");
		}
		return responseText;
	}
	
	@RequestMapping(value = "/topics/{topicId}/courses/{courseId}/lectures/{lectureId}", method = RequestMethod.PUT)
	public ResponseText updateLecture (@RequestBody Lecture lecture, @PathVariable String topicId, @PathVariable String courseId) {
		ResponseText responseText = new ResponseText();
		try {
			lecture.setCourse(new Course(courseId, "", "", topicId));
			lectureService.updateLecture(lecture);
			responseText.setResponse("Success");
		} catch (Exception e) {
			responseText.setResponse("Failure");
		}
		return responseText;
	}
	
	@RequestMapping(value = "/topics/{topicId}/courses/{courseId}/lectures/{lectureId}", method = RequestMethod.DELETE)	
	public ResponseText deleteLecture (@PathVariable String lectureId) {
		ResponseText responseText = new ResponseText();
		try {
			lectureService.deleteLecture(lectureId);
			responseText.setResponse("Success");
		} catch (Exception e) {
			responseText.setResponse("Failure");
		}
		return responseText;
	}

}
