/**
 * 
 */
package com.vishwa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vishwa.dao.RoleDao;
import com.vishwa.entity.Role;
/**
 * @author evishha
 *
 */
@Repository
public class RoleDaoImpl extends GenericDaoImpl<Role, Integer> implements RoleDao {
	
	@Override	
	public int save(Role entity) {
		return super.save(entity);						
	}

	@Override
	public Role findById(Class<Role> entity, Integer id) {
		return super.findById(entity, id);
	}

	@Override
	public List<Role> findAll(Class<Role> entity) {
		return super.findAll(entity);
	}

}
