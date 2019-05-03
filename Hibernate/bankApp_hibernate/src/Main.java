package com.capgemini.hibernate.test;

import com.capgemini.hibernate.util.*;
import com.capgemini.hibernate.dao.*;
import com.capgemini.hibernate.impl.*;
import com.capgemini.hibernate.model.*;

public class Main
{
	public static void main(String args[])
	{
		PersonDao personDao = new PersonDaoImpl();
		personDao.addNew(new Person(101,"Partiksha"));
		System.out.println("Ureka");
	}
}