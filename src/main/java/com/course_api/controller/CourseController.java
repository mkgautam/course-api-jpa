package com.course_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.course_api.model.Course;
import com.course_api.model.ResponseText;
import com.course_api.model.Topic;
import com.course_api.service.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value = "/topics/{topicId}/courses")
	public List<Course> getAllCourse (@PathVariable String topicId) {
		return courseService.getAllCourse(topicId);
	}
	
	@RequestMapping(value = "/topics/{topicId}/courses/{courseId}")
	public Course getCourse (@PathVariable String courseId) {
		return courseService.getCourse(courseId);
	}
	
	@RequestMapping(value = "/topics/{topicId}/courses", method = RequestMethod.POST)
	public ResponseText addCourse (@RequestBody Course course, @PathVariable String topicId) {
		ResponseText responseText = new ResponseText();
		try {
			course.setTopic(new Topic(topicId, "", ""));
			courseService.addCourse(course);
			responseText.setResponse("Success");
		} catch (Exception e) {
			responseText.setResponse("Failure");
		}
		return responseText;
	}
	
	@RequestMapping(value = "/topics/{topicId}/courses/{courseId}", method = RequestMethod.PUT)
	public ResponseText updateCourse (@RequestBody Course course, @PathVariable String topicId) {
		ResponseText responseText = new ResponseText();
		try {
			course.setTopic(new Topic(topicId, "", ""));
			courseService.updateCourse(course);
			responseText.setResponse("Success");
		} catch (Exception e) {
			responseText.setResponse("Failure");
		}
		return responseText;
	}
	
	@RequestMapping(value = "/topics/{topicId}/courses/{courseId}", method = RequestMethod.DELETE)	
	public ResponseText deleteCourse (@PathVariable String courseId) {
		ResponseText responseText = new ResponseText();
		try {
			courseService.deleteCourse(courseId);
			responseText.setResponse("Success");
		} catch (Exception e) {
			responseText.setResponse("Failure");
		}
		return responseText;
	}
	
}
