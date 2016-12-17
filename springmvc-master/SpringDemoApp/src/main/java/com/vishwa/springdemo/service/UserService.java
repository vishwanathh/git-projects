/**
 * 
 */
package com.vishwa.springdemo.service;

import java.util.List;

import com.vishwa.entity.User;

/**
 * @author evishha
 *
 */
public interface UserService {
	void createUser(User user);
	List<User> getUser();
	User getUserById(int id); 
	void removeUser(int id);
	void updateUser(User user);
}
