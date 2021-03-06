package com.brycen.hrm.implService.empRole;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.brycen.hrm.model.empRole.Permission;
import com.brycen.hrm.repository.empRole.PermissionRepository;
import com.brycen.hrm.service.empRole.PermissionService;

@Service
public class PermissionImplService implements PermissionService{
	private PermissionRepository perRep;

	@Autowired
	public PermissionImplService(PermissionRepository perRep) {
		this.perRep = perRep;
	}

	@Override
	public Page<Permission> findAllPermission(Pageable pageable) {
		return perRep.findAll(pageable);
	}

	@Override
	public Optional<Permission> findPermissionById(int id) {
		Optional<Permission> permission = perRep.findById(id);
		return permission;
	}

	@Override
	public void save(Permission permission) {
		perRep.save(permission);
	}

	@Override
	public void remove(Permission permission) {
		perRep.delete(permission);
	}
}
