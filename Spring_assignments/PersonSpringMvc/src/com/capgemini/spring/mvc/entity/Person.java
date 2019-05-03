package com.capgemini.spring.mvc.entity;

public class Person {
	private int personnId;
	private String  personName;
	
	public Person() {

	}

	public Person(int personnId, String personName) {
		super();
		this.personnId = personnId;
		this.personName = personName;
	}

	public int getPersonnId() {
		return personnId;
	}

	public void setPersonnId(int personnId) {
		this.personnId = personnId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

}
