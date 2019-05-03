package com.capgemini.spring.mvc.model.service;

import java.util.List;


import com.capgemini.spring.mvc.dao.PersonDao;
import com.capgemini.spring.mvc.model.entity.Person;

public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao person;
	@Override
	public void addNew(Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Person> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int personId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Person getPerson(int personId) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
