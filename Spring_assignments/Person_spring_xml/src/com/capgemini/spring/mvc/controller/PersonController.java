package com.capgemini.spring.mvc.controller;

import com.capgemini.spring.mvc.model.entity.Person;

public class PersonController {
	@Autowired
	private PersonsService service;

	@RequestMapping
	public String inputPage() {
		return "input";

	}

	@RequestMapping("/new")
	public String addNewPerson(@RequestParam("personId") int personId, @RequestParam("personName") String personName) {

		Person person = new Person(personId, personName);

		service.addNew(person);
		return "success";

	}

}
