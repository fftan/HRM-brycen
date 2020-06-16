package com.brycen.hrm.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.brycen.hrm.model.Permission;

public interface PermissionService {
	Page<Permission> findAllPermission(Pageable pageable);
	
	Optional<Permission> findPermissionById(int id);
	
	void save(Permission permission);
	
	void remove(Permission permission);
}
