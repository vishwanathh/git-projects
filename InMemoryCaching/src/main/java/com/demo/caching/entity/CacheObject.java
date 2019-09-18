/**
 * 
 */
package com.demo.caching.entity;

/**
 * @author evishha
 *
 */
public class CacheObject {

	private String value;
	private long expiryTime;
	
	public CacheObject(String value, long expiryTime) {
		super();
		this.value = value;
		this.expiryTime = expiryTime;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isExpired() {
		return System.currentTimeMillis() > expiryTime;
	}


}
