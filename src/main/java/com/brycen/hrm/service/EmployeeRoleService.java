package com.brycen.hrm.service;

import java.util.List;
import java.util.Optional;

import com.brycen.hrm.model.EmployeeRole;

public interface EmployeeRoleService {
	List<EmployeeRole> findAll();

	Optional<EmployeeRole> findById(int id);

	void save(EmployeeRole empRole);
}
