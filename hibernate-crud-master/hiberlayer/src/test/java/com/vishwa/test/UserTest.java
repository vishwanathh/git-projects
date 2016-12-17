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
import com.vishwa.entity.User;

/**
 * @author evishha
 *
 */
public class UserTest {

	private static UserDao dao;
	private static User entity;
	private static final String USERNAME = "vishyh";
	private static final String EMAIL = "vishy@git.com"
	private static final String USERNAME_2 = "vishwanathh";
	private static final String EMAIL_2 = "vishwanathh@git.com";
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = new UserDaoImpl();
	    entity = new User();
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
		//TODO: add code that will be invoked before every test!
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		// TODO: add code that will be invoked after every test!
	}
	
	@Test
	public void testUser() {
		testSave();
		testUpdate();
		testFindAll();
		testFindById();
		testDelete();
	}
	
	public void testSave() {		
		entity.setUsername(USERNAME);
		entity.setEmail(EMAIL);		
		int id = dao.save(entity);
		entity.setUserId(id);
		System.out.println("Entity User Created: " + entity.toString());
	}
	
	public void testUpdate() {
		entity.setUsername(USERNAME_2);
		entity.setEmail(EMAIL_2);
		dao.update(entity);	
		System.out.println("Entity User Updated: " + entity.toString());
	}
	
	public void testDelete() {
		dao.delete(entity);
		System.out.println("Entity User Removed, Tests Completed!");
	}
	
	public void testFindAll() {
	    List<User> users = dao.findAll(User.class);
	    System.out.println("FindAll records : " + users.toString());
	}
	
	public void testFindById() {
		Integer id = entity.getUserId();
		User searched = dao.findById(User.class, id);
		System.out.println("Find results for User #"+ id + ": " + searched.toString());
	}	
}
