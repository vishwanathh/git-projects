/**
 * 
 */
package com.vishwa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vishwa.dao.UserDao;
import com.vishwa.entity.User;

/**
 * @author evishha
 *
 */
@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao {
	
	@Override	
	public int save(User entity) {
		return super.save(entity);						
	}

	@Override
	public User findById(Class<User> entity, Integer id) {
		return super.findById(entity, id);
	}

	@Override
	public List<User> findAll(Class<User> entity) {
		return super.findAll(entity);
	}

}
