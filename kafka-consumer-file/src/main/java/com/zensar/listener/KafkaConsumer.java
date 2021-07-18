package com.zensar.listener;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.zensar.model.Person;
import com.zensar.service.PersonService;
import com.zensar.utils.JsonToObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class KafkaConsumer {

	private static final Logger LOG = LoggerFactory.getLogger(KafkaConsumer.class);

	@Autowired
	PersonService personService;
	
	@KafkaListener(topics = "person-json-file-topic", groupId = "group_id")
	public void consume(String message) throws IOException {

		LOG.info("Consumed message =>: " + message);

		//converting json to data object
		Person person = JsonToObject.processing(Person.class, message);

		// save person
		personService.saveOrUpdate(person);
	}

}
