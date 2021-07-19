package com.zensar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.model.Person;
import com.zensar.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	PersonService personService;

	@GetMapping("/persons")
	private List<Person> persons() {
		return personService.getPersons();
	}

	@GetMapping("/person/{id}")
	private Person gertPerson(@PathVariable("id") Long personId) {
		return personService.getPersonById(personId);
	}

	@DeleteMapping("/person/{id}")
	private void deleteBook(@PathVariable("id") Long personId) {
		personService.delete(personId);
	}

	@PostMapping("/person")
	private Long saveBook(@RequestBody Person person) {
		personService.saveOrUpdate(person);
		return person.getId();
	}

	@PutMapping("/person")
	private Person update(@RequestBody Person person) {
		personService.saveOrUpdate(person);
		return person;
	}
}
