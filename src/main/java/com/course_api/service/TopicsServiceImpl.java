package com.course_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course_api.model.Topic;
import com.course_api.repository.TopicRepository;

@Service
public class TopicsServiceImpl implements TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	@Override
	public List<Topic> getAllTopics () {
		return topicRepository.getAllTopics();
	}
	
	@Override
	public Topic getTopic (String id) {
		return topicRepository.getTopic(id);
	}

	@Override
	public void addTopic(Topic topic) {
		topicRepository.addTopic(topic);
	}

	@Override
	public void updateTopic(Topic topic, String id) {
		topicRepository.updateTopic(topic, id);
	}

	@Override
	public void deleteTopic(String id) {
		topicRepository.deleteTopic(id);
	}
	
}
