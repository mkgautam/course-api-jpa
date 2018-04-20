package com.course_api.repository;

import org.springframework.data.repository.CrudRepository;

import com.course_api.model.Topic;

public interface CrudRepositoryImpl extends CrudRepository<Topic, String> {

}
