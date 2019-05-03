package com.capgemini.hibernate.impl;
import com.capgemini.hibernate.dao.*;
import com.capgemini.hibernate.util.*;
import javax.persistence.*;
import com.capgemini.hibernate.model.*;
import org.hibernate.boot.registry.*;
import org.hibernate.boot.*;
import org.hibernate.*;
import javax.persistence.*;


public class PersonDaoImpl implements PersonDao
{
	public void addNew(Person person)
	{
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(person);
		tx.commit();
		
	}
}