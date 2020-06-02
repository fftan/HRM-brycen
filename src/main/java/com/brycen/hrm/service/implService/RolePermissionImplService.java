package com.brycen.hrm.service.implService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brycen.hrm.model.RolePermission;
import com.brycen.hrm.repository.RolePermissionRepository;
import com.brycen.hrm.service.RolePermissionService;

@Service
public class RolePermissionImplService implements RolePermissionService{
	private RolePermissionRepository rolePerRep;

	@Autowired
	public RolePermissionImplService(RolePermissionRepository rolePerRep) {
		this.rolePerRep = rolePerRep;
	}

	@Override
	public List<RolePermission> findAll() {
		List<RolePermission> rolePers = (List<RolePermission>) rolePerRep.findAll();
		return rolePers;
	}

	@Override
	public Optional<RolePermission> findById(int id) {
		Optional<RolePermission> rolePer = rolePerRep.findById(id);
		return rolePer;
	}

	@Override
	public void save(RolePermission rolePermission) {
		rolePerRep.save(rolePermission);
	}

	@Override
	public void remove(RolePermission rolePermission) {
		rolePerRep.delete(rolePermission);
	}
}
