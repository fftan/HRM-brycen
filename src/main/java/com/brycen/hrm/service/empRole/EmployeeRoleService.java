package com.brycen.hrm.service.empRole;

import java.util.List;
import java.util.Optional;

import com.brycen.hrm.model.empRole.EmployeeRole;

public interface EmployeeRoleService {
	List<EmployeeRole> findAll();

	Optional<EmployeeRole> findById(int id);

	void save(EmployeeRole empRole);
}
