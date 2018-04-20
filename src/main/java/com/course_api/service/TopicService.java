package com.course_api.service;

import java.util.List;

import com.course_api.model.Topic;

public interface TopicService {

	List<Topic> getAllTopics();
	Topic getTopic(String id);
	void addTopic(Topic topic);
	void updateTopic(Topic topic, String id);
	void deleteTopic(String id);

}