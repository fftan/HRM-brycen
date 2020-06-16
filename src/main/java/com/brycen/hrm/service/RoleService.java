package com.brycen.hrm.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.brycen.hrm.model.Role;

public interface RoleService {
	Page<Role> findAllRole(Pageable pageable);
	
	Optional<Role> findRoleById(int id);
	
	void save(Role role);
	
	void remove(Role role);
}
