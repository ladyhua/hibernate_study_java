package com.hibernate.model;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class SchemaExportText {
	
	public static SessionFactory sf=null;
	@BeforeClass
	public static void beforeClass(){
		sf=new Configuration().configure().buildSessionFactory();
	}

	@Test
	public void testSchemaExport() {
		ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().configure().build();
		MetadataImplementor metadata=(MetadataImplementor)new MetadataSources(serviceRegistry).buildMetadata();
		new SchemaExport(metadata).create(false,true);
	}
	@AfterClass
	public static void afterClass(){
		sf.close();
	}
}
