package com.demo.caching.impl;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import com.demo.caching.Cache;
import com.demo.caching.entity.CacheObject;
import com.demo.caching.exception.CacheException;

public class InMemoryCache implements Cache {

	private static final int CLEAN_UP_PERIOD_IN_SEC = 5;
    private final ConcurrentHashMap<String, CacheObject> cacheStore = new ConcurrentHashMap<>();

	public InMemoryCache() {

		Thread cleanupThread = new Thread(() -> {
			while (!Thread.currentThread().isInterrupted()) {
				try {
					
					Thread.sleep(CLEAN_UP_PERIOD_IN_SEC * 1000);
					cacheStore.entrySet().removeIf(entry -> 
						Optional.ofNullable(entry.getValue()).map(CacheObject::isExpired).orElse(false));
					
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		});
		cleanupThread.setDaemon(true);
		cleanupThread.start();
	}

	@Override
	public void add(String key, String value, long periodInMillis) {
		
		if (key.isEmpty() || value.isEmpty() || key == null || value == null ) {
			return;
		}
	
		long expiryTime = System.currentTimeMillis() + periodInMillis;
		cacheStore.put(key, new CacheObject(value, expiryTime));

	}

	@Override
	public void remove(String key) {		
		cacheStore.remove(key);

	}

	@Override
	public String get(String key) {
		CacheObject cacheobj = cacheStore.get(key);
		if (cacheobj !=null && !cacheobj.isExpired()) {
			return cacheobj.getValue();
		}
		return null;
	}

	@Override
	public void clear() {
		cacheStore.clear();
	}

	@Override
	public long size() {
        return cacheStore.size();
	}

}
