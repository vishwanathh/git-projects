package com.demo.caching;

import com.demo.caching.exception.CacheException;

public interface Cache {
	
	void add(String key, String value, long periodInMillis);

	void remove(String key);

	Object get(String key);

	void clear();

	long size();

	

}
