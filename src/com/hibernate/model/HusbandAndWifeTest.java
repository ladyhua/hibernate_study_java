package com.hibernate.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HusbandAndWifeTest {
	public static void main(String[] args){
		Husband h=new Husband();
		Wife w=new Wife();
		h.setName("h1");
		w.setName("w1");
		h.setWife(w);
		
		Configuration cfg=new Configuration();
		SessionFactory sf=cfg.configure().buildSessionFactory();
		Session session=sf.getCurrentSession();
		session.beginTransaction();
		session.save(h);
		session.save(w);
		session.getTransaction().commit();
	}
}
