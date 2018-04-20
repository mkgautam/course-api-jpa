package com.course_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.course_api.model.ResponseText;
import com.course_api.model.Topic;
import com.course_api.service.TopicService;

@RestController
public class TopicsController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping(value = "/topics")
	public List<Topic> getTopics () {
		return topicService.getAllTopics();
	}
	
	/*@RequestMapping(value = "/topics/{any_name}")
	public Topics getTopic (@PathVariable("any_name") String id) {*/
			// or
	@RequestMapping(value = "/topics/{id}")
	public Topic getTopic (@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(value = "/topics", method = RequestMethod.POST)
	public ResponseText addTopic (@RequestBody Topic topic) {
		ResponseText responseText = new ResponseText();
		try {
			topicService.addTopic(topic);
			responseText.setResponse("Success");
		} catch (Exception e) {
			responseText.setResponse("Failure");
		}
		return responseText;
	}
	
	@RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT)
	public ResponseText updateTopic (@RequestBody Topic topic, @PathVariable String id) {
		ResponseText responseText = new ResponseText();
		try {
			topicService.updateTopic(topic, id);
			responseText.setResponse("Success");
		} catch (Exception e) {
			responseText.setResponse("Failure");
		}
		return responseText;
	}
	
	@RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)	
	public ResponseText deleteTopic (@PathVariable String id) {
		ResponseText responseText = new ResponseText();
		try {
			topicService.deleteTopic(id);
			responseText.setResponse("Success");
		} catch (Exception e) {
			responseText.setResponse("Failure");
		}
		return responseText;
	}
	
}
