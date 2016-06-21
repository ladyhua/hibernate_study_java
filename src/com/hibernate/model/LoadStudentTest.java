package com.hibernate.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LoadStudentTest {
	public static void main(String[] args){
		Configuration cfg=new Configuration();
		SessionFactory sf=cfg.configure().buildSessionFactory();
		Session session=sf.getCurrentSession();
		session.beginTransaction();
		Student s=session.load(Student.class, 1);
		System.out.println(s.getName());
		session.getTransaction().commit();
		//System.out.println(s.getName());
	}
}
