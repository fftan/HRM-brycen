package com.brycen.hrm.service.implService;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.brycen.hrm.model.EmployeeRole;
import com.brycen.hrm.repository.EmployeeRoleRepository;
import com.brycen.hrm.service.EmployeeRoleService;

@Service
public class EmployeeRoleImplService implements EmployeeRoleService{
	private EmployeeRoleRepository empRoleRep;

	public EmployeeRoleImplService(EmployeeRoleRepository empRoleRep) {
		super();
		this.empRoleRep = empRoleRep;
	}

	@Override
	public List<EmployeeRole> findAll() {
		return empRoleRep.findAll();
	}

	@Override
	public Optional<EmployeeRole> findById(int id) {
		return empRoleRep.findById(id);
	}

	@Override
	public void save(EmployeeRole empRole) {
		empRoleRep.save(empRole);
	}
}
