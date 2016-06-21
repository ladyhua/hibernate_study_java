package com.hibernate.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class StudentTest {
	public static SessionFactory sf=null;
	@BeforeClass
	public static void beforeClass(){
		sf=new Configuration().configure().buildSessionFactory();
	}

	@Test
	public void studentTestSave() {
		Student s=new Student();
		s.setName("s6");
		s.setAge(6);
		
		Session session=sf.getCurrentSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		
	}
	
	@AfterClass
	public static void afterClass(){
		sf.close();
	}

}
