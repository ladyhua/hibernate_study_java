package com.hibernate.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserAndGroupTest {
	public static SessionFactory sf=null;
	@BeforeClass
	public static void beforeClass(){
		sf=new Configuration().configure().buildSessionFactory();
	}
	@Test
	public void test() {
		User u=new User();
		u.setName("u1");
		Group g=new Group();
		g.setName("g1");
		User u1=new User();
		u1.setName("u2");
		u1.setGroup(g);
		u.setGroup(g);
		Session session=sf.openSession();
		session.beginTransaction();
		session.save(u);
		session.save(g);
		session.save(u1);
		session.getTransaction().commit();
		session.close();
	}
	@AfterClass
	public static void afterClass(){
		
		sf.close();
		
	}
}
