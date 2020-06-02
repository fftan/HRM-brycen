package com.brycen.hrm.service;

import java.util.List;
import java.util.Optional;

import com.brycen.hrm.model.Role;

public interface RoleService {
	List<Role> findAllRole();
	
	Optional<Role> findRoleById(int id);
	
	void save(Role role);
	
	void remove(Role role);
}
