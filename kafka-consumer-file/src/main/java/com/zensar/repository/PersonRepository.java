package com.zensar.repository;

import org.springframework.stereotype.Repository;

import com.zensar.model.Person;

import org.springframework.data.repository.CrudRepository;


@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
}
