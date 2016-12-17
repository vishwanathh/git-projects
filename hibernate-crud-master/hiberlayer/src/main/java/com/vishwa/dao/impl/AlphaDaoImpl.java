/**
 * 
 */
package com.vishwa.dao.impl;

import java.util.List;

import com.vishwa.dao.AlphaDao;
import com.vishwa.entity.Alpha;
/**
 * @author evishha
 *
 */
public class AlphaDaoImpl extends GenericDaoImpl<Alpha, Integer> implements AlphaDao {
	
	@Override	
	public int save(Alpha entity) {
		return super.save(entity);						
	}

	@Override
	public Alpha findById(Class<Alpha> entity, Integer id) {
		return super.findById(entity, id);
	}

	@Override
	public List<Alpha> findAll(Class<Alpha> entity) {
		return super.findAll(entity);
	}

}
