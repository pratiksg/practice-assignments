package com.capgemini.spring.mvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capgemini.spring.mvc.model.entity.Person;
import com.capgemini.spring.mvc.model.service.PersonsService;

@Repository
public class PersonDaoImpl implements PersonDao  {

	@Autowired
	private JdbcTemplate template;
	@Override
	public void addNew(Person person) {
		template.update("INSERT INTO PERSON VALUES(?,?)",
				new Object[] {person.getPersonId(),person.getPersonName()});
		
	}
	public JdbcTemplate getTemplate() {
		return template;
	}
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	
}
