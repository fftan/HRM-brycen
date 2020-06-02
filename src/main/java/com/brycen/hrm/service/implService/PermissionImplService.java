package com.brycen.hrm.service.implService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brycen.hrm.model.Permission;
import com.brycen.hrm.repository.PermissionRepository;
import com.brycen.hrm.service.PermissionService;

@Service
public class PermissionImplService implements PermissionService{
	private PermissionRepository perRep;

	@Autowired
	public PermissionImplService(PermissionRepository perRep) {
		this.perRep = perRep;
	}

	@Override
	public List<Permission> findAllPermission() {
		List<Permission> perList = (List<Permission>) perRep.findAll();
		return perList;
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
