package com.capgemini.spring.mvc.model.Service;

import java.util.List;

import com.capgemini.spring.mvc.entity.Person;

public interface PersonService {
	void addNew(Person person);

	List<Person> getAll();

	void update(Person person);

	void delete(int personId);

	Person getPerson(int personId);

}
