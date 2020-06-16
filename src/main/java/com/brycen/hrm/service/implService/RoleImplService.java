package com.brycen.hrm.service.implService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.brycen.hrm.model.Role;
import com.brycen.hrm.repository.RoleRepository;
import com.brycen.hrm.service.RoleService;

@Service
public class RoleImplService implements RoleService{
	private RoleRepository roleRep;

	@Autowired
	public RoleImplService(RoleRepository roleRep) {
		this.roleRep = roleRep;
	}

	@Override
	public Page<Role> findAllRole(Pageable pageable) {
		return roleRep.findAll(pageable);
	}

	@Override
	public Optional<Role> findRoleById(int id) {
		Optional<Role> role = roleRep.findById(id);
		return role;
	}

	@Override
	public void save(Role role) {
		roleRep.save(role);
	}

	@Override
	public void remove(Role role) {
		roleRep.delete(role);
	}
}
