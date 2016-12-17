/**
 * 
 */
package com.vishwa.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author evishha
 *
 */
public interface GenericDao<E, ID extends Serializable> {
	int save(E entity);
	void delete(E entity);
	void update(E entity);
	E findById(Class<E> entity, Integer id);
	List<E> findAll(Class<E> entity);
}
