package com.course_api.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course_api.model.Topic;
import com.course_api.repository.TopicRepository;

@Service
public class TopicsServiceImpl implements TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("java", "Core Java", "A course on java fundamentals"),
			new Topic("js", "Java Script", "A course on java script fundamentals"),
			new Topic("spring", "Spring Framework", "A course on spring framework"),
			new Topic("hibernate", "Hibernate Framework", "A course on hibernate framework")
		));
	
	@Override
	public List<Topic> getAllTopics () {
		return topicRepository.getAllTopics();
	}
	
	@Override
	public Topic getTopic (String id) {
		for (Topic top : topics) {
			if(top.getId().equalsIgnoreCase(id)) {
				return top;
			}
		}
		return null;
	}

	@Override
	public void addTopic(Topic topic) {
		topicRepository.addTopic(topic);
	}

	@Override
	public void updateTopic(Topic topic, String id) {
		for (int i = 0; i < topics.size(); i++) {
			Topic top = topics.get(i);
			if (top.getId().equalsIgnoreCase(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}

	@Override
	public void deleteTopic(String id) {
		for (Topic top : topics) {
			if(top.getId().equalsIgnoreCase(id)) {
				topics.remove(top);
				return;
			}
		}
	}
	
}
