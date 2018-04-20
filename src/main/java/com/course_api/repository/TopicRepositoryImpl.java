package com.course_api.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.course_api.model.Topic;

@Repository
public class TopicRepositoryImpl implements TopicRepository {
	
	@Autowired
	private CrudRepositoryImpl crudRepositoryImpl;

	@Override
	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		for (Topic topic : crudRepositoryImpl.findAll()) {
			topics.add(topic);
		}
		return topics;
	}

	@Override
	public void addTopic(Topic topic) {
		try {
			crudRepositoryImpl.save(topic);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
