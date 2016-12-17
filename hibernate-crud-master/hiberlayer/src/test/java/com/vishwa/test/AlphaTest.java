/**
 * 
 */
package com.vishwa.test;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.vishwa.dao.*;
import com.vishwa.dao.impl.*;
import com.vishwa.entity.*;

/**
 * @author evishha
 *
 */
public class AlphaTest {

	private static AlphaDao dao;
	private static Alpha entity;	
	private static final String USERNAME = "alphafoo";
	private static final String USERNAME_2 = "alphafoo2";
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = new AlphaDaoImpl();
	    entity = new Alpha();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
		entity = null;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
				
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		// TODO: add code that will be invoked after every test!
	}
	
	@Test 
	public void testAlpha() {
		testSave();
		testUpdate();
		testFindAll();
		testFindById();
		testDelete();
	}
	
	public void testSave() {		
		entity.setAlphaName(USERNAME);
		int id = dao.save(entity);
		entity.setAlphaId(id);
		System.out.println("Entity Alpha Created: " + entity.toString());
	}
	
	public void testUpdate() {
		entity.setAlphaName(USERNAME_2);
		dao.update(entity);	
		System.out.println("Entity Alpha Updated: " + entity.toString());
	}
	
	public void testDelete() {
		dao.delete(entity);
		System.out.println("Entity Alpha Removed, Tests Completed!");
	}
	
	public void testFindAll() {
	    List<Alpha> users = dao.findAll(Alpha.class);	    
	    System.out.println("FindAll records : " + users.toString());	    		
	}
	
	public void testFindById() {
		Integer id = entity.getAlphaId();
		entity = dao.findById(Alpha.class, id);
		System.out.println("Find results for Alpha #"+ id + ": " + entity.toString());
	}	
}
