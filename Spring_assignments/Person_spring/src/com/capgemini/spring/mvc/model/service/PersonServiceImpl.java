package com.capgemini.spring.mvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.spring.mvc.model.dao.PersonDao;
import com.capgemini.spring.mvc.model.entity.Person;



public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao person;

	public void addNew(Person person) {
		// TODO Auto-generated method stub
		
	}
	
	

}
