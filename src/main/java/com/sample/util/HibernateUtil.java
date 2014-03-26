package com.sample.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory=null;
	
	static {
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}

	public HibernateUtil() {
		super();
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}

	public static void cleanUp() {
		sessionFactory.close();
	}
}
