/**
 * 
 */
package com.vishwa.entity;

/**
 * @author evishha
 *
 */
public class User {
	private int userId;
	private String username;
	private String email;
		
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", email="
				+ email + "]";
	}	

}
