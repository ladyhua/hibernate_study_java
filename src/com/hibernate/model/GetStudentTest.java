package com.hibernate.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetStudentTest {
	public static void main(String[] args){
		Configuration cfg=new Configuration();
		SessionFactory sf=cfg.configure().buildSessionFactory();
		Session session=sf.getCurrentSession();
		session.beginTransaction();
		Student s=session.get(Student.class, 1);
		session.getTransaction().commit();
		System.out.println(s.getName());
	}
}
