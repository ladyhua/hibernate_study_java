package com.hibernate.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentTest {
	public static  void main(String[] args){
		Student s=new Student();
		s.setId(4);
		
		Configuration cfg=new Configuration();
		SessionFactory sf=cfg.configure().buildSessionFactory();
		Session session=sf.getCurrentSession();
		session.beginTransaction();
		session.delete(s);
		session.getTransaction().commit();
	}
	
}
