package com.zensar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person { 
	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public String gender;
	public String firstname;
	public String lastname;
	
	public Person() {
	}
	
	public Person(Long id, String gender, String firstname, String lastname) {
		super();
		this.id = id;
		this.gender = gender;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", gender=" + gender + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
}

