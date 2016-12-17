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
import com.vishwa.entity.Role;

/**
 * @author evishha
 *
 */
public class RoleTest {

	private static RoleDao dao;
	private static Role entity;
	private static final String ROLENAME = "root";
	private static final String ROLETYPE = "Admin";
	private static final String ROLENAME_2 = "sudo";
	private static final String ROLETYPE_2 = "SuperUser";
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = new RoleDaoImpl();
	    entity = new Role();
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
	public void testRole() {
		testSave();
		testUpdate();
		testFindAll();
		testFindById();
		testDelete();
	}
	
	public void testSave() {
		entity.setRoleName(ROLENAME);
		entity.setRoleType(ROLETYPE);
		int id = dao.save(entity);
		entity.setRoleId(id);
		System.out.println("Entity Role Created: " + entity.toString());
	}
	
	public void testUpdate() {
		entity.setRoleName(ROLENAME_2);
		entity.setRoleType(ROLETYPE_2);
		dao.update(entity);	
		System.out.println("Entity Role Updated: " + entity.toString());
	}
	
	public void testDelete() {
		dao.delete(entity);
		System.out.println("Entity User Removed, Tests Completed!");
	}
	
	public void testFindAll() {
	    List<Role> roles = dao.findAll(Role.class);
	    System.out.println("FindAll records : " + roles.toString());	    		
	}
	
	public void testFindById() {
		Integer id = entity.getRoleId();
		Role searched = dao.findById(Role.class, id);
		System.out.println("Find results for Role #"+ id + ": " + searched.toString());
	}	
}
