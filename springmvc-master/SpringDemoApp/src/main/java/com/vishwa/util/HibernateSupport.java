/**
 * 
 */
package com.vishwa.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author evishha
 *
 */
public class HibernateSupport {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch(Throwable error) {
			throw new ExceptionInInitializerError(error);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}	
}
