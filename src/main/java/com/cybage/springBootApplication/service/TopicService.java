package com.cybage.springBootApplication.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.springBootApplication.bean.Topics;
import com.cybage.springBootApplication.repository.TopicRepository;

@Service
public class TopicService {

	@Autowired
	private TopicRepository repository;
	/*List<Topics> topicsList = new ArrayList<Topics>(Arrays.asList(new Topics("1", "java", "java is good language"),
		new Topics("2", "js", "js is good language")));*/
	List<Topics> topicsList = new ArrayList<Topics>();
	public List<Topics> getAllTopics() {
		List<Topics> topicsList = new ArrayList<Topics>();
		for (Topics t : repository.findAll()) {
			topicsList.add(t);
		}
		
		
		return topicsList;
	}
	
	public Topics getTopic(String id) {
		//return topicsList.stream().filter(n -> n.getId().equals(id)).findFirst().get();
		return repository.findOne(id);
	}

	public void addTopic(Topics topics) {
		//topicsList.add(topics);
		repository.save(topics);
	}

	public void updateTopic(Topics topics, String id) {
		/*for (int i=0; i<topicsList.size(); i++) {
			if (id.equals(topicsList.get(i).getId())) {
				topicsList.set(i, topics);
				return;
			}
		}*/
		repository.save(topics);
	}

	public void removeTopic(String id) {
		//topicsList.removeIf(n -> n.getId().equals(id));
		repository.delete(id);
	}

}
