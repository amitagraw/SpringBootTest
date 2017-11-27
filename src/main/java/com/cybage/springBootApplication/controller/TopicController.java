package com.cybage.springBootApplication.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.springBootApplication.bean.Topics;
import com.cybage.springBootApplication.service.TopicService;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topics> getAllTopics() {
		return topicService.getAllTopics();
	}
	@RequestMapping("/topics/{id}")
	public Topics getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value= "/topics")
	public void addTopic(@RequestBody Topics topics) {
		topicService.addTopic(topics);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value= "/topics/{id}")
	public void updateTopic(@RequestBody Topics topics, @PathVariable String id) {
		topicService.updateTopic(topics, id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value= "/topics/{id}")
	public void removeTopic(@PathVariable String id) {
		topicService.removeTopic(id);
	}
}
