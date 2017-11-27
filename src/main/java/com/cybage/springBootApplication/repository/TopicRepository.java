package com.cybage.springBootApplication.repository;

import org.springframework.data.repository.CrudRepository;

import com.cybage.springBootApplication.bean.Topics;

public interface TopicRepository extends CrudRepository<Topics, String>{

}
