package com.brycen.hrm.service.empRole;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.brycen.hrm.model.empRole.Role;

public interface RoleService {
	Page<Role> findAllRole(Pageable pageable);
	
	List<Role> listAll();
	
	Optional<Role> findRoleById(int id);
	
	void save(Role role);
	
	void remove(Role role);
}
