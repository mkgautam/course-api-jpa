package com.course_api.repository;

import java.util.List;

import com.course_api.model.Topic;

public interface TopicRepository {

	List<Topic> getAllTopics();

	void addTopic(Topic topic);

}
