package com.brycen.hrm.service.empRole;

import java.util.List;
import java.util.Optional;

import com.brycen.hrm.model.empRole.RolePermission;

public interface RolePermissionService {
	List<RolePermission> findAll();

	Optional<RolePermission> findById(int id);

	void save(RolePermission rolePermission);

	void remove(RolePermission rolePermission);
}
