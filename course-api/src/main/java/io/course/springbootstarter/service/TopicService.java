package io.course.springbootstarter.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import io.course.springbootstarter.model.Topic;

@Service
public class TopicService {
	private List<Topic> topics = new ArrayList<Topic>(
			Arrays.asList(new Topic("Spring", "Spring frmework", "spring description"),
					new Topic("Java", "Java frmework", "Java description"),
					new Topic("Hibernate", "Hibernate frmework", "Hibernate description")));

	public List<Topic> getAllTopics() {
		return topics;
	}

	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(Topic topic, String id) {
		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
		return;
	}

}
