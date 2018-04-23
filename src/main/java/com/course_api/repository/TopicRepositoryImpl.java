package com.course_api.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.course_api.model.Topic;

@Repository
public class TopicRepositoryImpl implements TopicRepository {
	
	@Autowired
	private Topic_CrudRepositoryImpl topicCrudRepositoryImpl;

	@Override
	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		for (Topic topic : topicCrudRepositoryImpl.findAll()) {
			topics.add(topic);
		}
		return topics;
	}

	@Override
	public void addTopic(Topic topic) {
		try {
			topicCrudRepositoryImpl.save(topic);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Topic getTopic(String id) {
		Optional<Topic> topicOptional = topicCrudRepositoryImpl.findById(id);
		if (topicOptional.isPresent()) {
			return topicOptional.get();
		} else {
			return new Topic();
		}
	}
	
	@Override
	public void updateTopic(Topic topic, String id) {
		topicCrudRepositoryImpl.save(topic);
	}

	@Override
	public void deleteTopic(String id) {
		topicCrudRepositoryImpl.deleteById(id);
	}

}
