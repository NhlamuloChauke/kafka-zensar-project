package com.zensar.service;

import java.util.List;

import com.zensar.model.Person;

public interface PersonService {
	void saveOrUpdate(Person person);
	List<Person> getPersons();
	Person getPersonById(Long id);
	void delete(Long id);
	void update(Person person, Long personid); 
}
