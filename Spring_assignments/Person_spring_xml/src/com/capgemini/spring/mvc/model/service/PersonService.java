package com.capgemini.spring.mvc.model.service;

import java.util.List;

import com.capgemini.spring.mvc.model.entity.Person;

public interface PersonService {

	List<Person> getAll();

	void update(Person person);

	void delete(int personId);

	void addNew(Person person);

	Person getPerson(int personId);

}
