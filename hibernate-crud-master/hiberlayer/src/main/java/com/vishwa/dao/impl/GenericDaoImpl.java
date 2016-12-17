/**
 * 
 */
package com.vishwa.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.vishwa.dao.GenericDao;
import com.vishwa.util.HibernateSupport;

/**
 * @author evishha
 *
 */
public class GenericDaoImpl<E, ID extends Serializable> implements GenericDao<E, ID> {
	
	private SessionFactory sessionFactory = HibernateSupport.getSessionFactory();
	
	public int save(E entity) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Integer id = null;
		try {
			tx = session.beginTransaction();
			id = (Integer) session.save(entity);
			session.getTransaction().commit();
		} catch(HibernateException error) {
			if (tx != null) tx.rollback();	
			error.printStackTrace();
		} finally {
			session.close();
		}
		return id;
	}

	@SuppressWarnings("unchecked")
	public E findById(Class<E> entity, Integer id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		E object = null;
		try {
			tx = session.beginTransaction();
			object = (E) session.get(entity, id);
		} catch (HibernateException error) {
			if (tx != null) tx.rollback();
			error.printStackTrace();
		} finally {
			session.close();
		}		
		return object;
	}

	@SuppressWarnings("unchecked")
	public List<E> findAll(Class<E> entity) {	
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<E> result = null;
		try {
			tx = session.beginTransaction();
			result = session.createQuery("from " + entity.getName()).list();
		} catch (HibernateException error) {
			if (tx != null) tx.rollback();
			error.printStackTrace();
		} finally {
			session.close();
		}
		return result;		
	}

	public void delete(E entity) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(entity);
			tx.commit();			
		} catch (HibernateException error) {
			if (tx != null) tx.rollback();
			error.printStackTrace();			
		} finally {
			session.close();
		}		
	}

	public void update(E entity) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(entity);
			tx.commit();			
		} catch (HibernateException error) {
			if (tx != null) tx.rollback();
			error.printStackTrace();
		} finally {
			session.close();
		}		
	}
}
