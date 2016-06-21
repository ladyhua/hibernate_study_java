package com.hibernate.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentTest {
	public static void main(String[] args){
	Configuration cfg=new Configuration();
	SessionFactory sf=cfg.configure().buildSessionFactory();
	Session session=sf.getCurrentSession();
	session.beginTransaction();
	Student s=(Student)session.get(Student.class, 1);
	session.getTransaction().commit();
	s.setName("s2");
	Session session2=sf.getCurrentSession();
	session2.beginTransaction();
	session2.update(s);
	session2.getTransaction().commit();
}
}