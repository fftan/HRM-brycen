package com.brycen.hrm.service.implService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.brycen.hrm.model.Department;
import com.brycen.hrm.repository.DepartmentRepository;
import com.brycen.hrm.service.DepartmentService;

@Service
public class DepartmentImpService implements DepartmentService{
	private DepartmentRepository depRep;
	
	@Autowired
	public DepartmentImpService(DepartmentRepository depRep) {
		this.depRep = depRep;
	}
	
	@Override
	public Page<Department> findAllDepartments(Pageable pageable) {
		return depRep.findAll(pageable);
	}

	@Override
	public Optional<Department> findById(int id) {
		Optional<Department> department = depRep.findById(id);
		return department;
	}

	@Override
	public void save(Department department) {
		depRep.save(department);
	}

	@Override
	public void remove(Department department) {
		depRep.delete(department);
	}
}
