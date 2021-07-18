package com.zensar.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.model.Person;
import com.zensar.repository.PersonRepository;
import com.zensar.service.PersonService;

@Service
@Transactional
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	PersonRepository repository;

	public void saveOrUpdate(Person person) {
		repository.save(person);
	}

	public List<Person> getPersons() {
		List<Person> persons = new ArrayList<Person>();  
		repository.findAll().forEach(persons1 -> persons.add(persons1));  
		return persons;  
	}

	public Person getPersonById(Long id) {
		return repository.findById(id).get();
	}

	public void delete(Long id) {
		repository.deleteById(id);  
	}

	public void update(Person person, Long personid) {
		repository.save(person);  
	}
}
