/**
 * 
 */
package com.vishwa.springdemo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vishwa.dao.UserDao;
import com.vishwa.entity.User;
import com.vishwa.springdemo.HomeController;
import com.vishwa.springdemo.service.UserService;

/**
 * @author evishha
 *
 */

@Service
public class UserServiceImpl implements UserService {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	UserDao userDao;
	
	@Override
	public void createUser(User user) {
		userDao.save(user);
	}

	@Override
	public List<User> getUser() {
		return userDao.findAll(User.class);
	}

	@Override
	public User getUserById(int id) {
		return userDao.findById(User.class, id);
	}

	@Override
	public void removeUser(int id) {
		User user = userDao.findById(User.class, id);
		userDao.delete(user);		
	}

	@Override
	public void updateUser(User user) {
		userDao.update(user);		
	}
	
}
