package com.brycen.hrm.service;

import java.util.List;
import java.util.Optional;

import com.brycen.hrm.model.Permission;

public interface PermissionService {
	List<Permission> findAllPermission();
	
	Optional<Permission> findPermissionById(int id);
	
	void save(Permission permission);
	
	void remove(Permission permission);
}
