package com.brycen.hrm.service;

import java.util.List;
import java.util.Optional;

import com.brycen.hrm.model.Department;

public interface DepartmentService {
	List<Department> findAllDepartments();
	
	Optional<Department> findById(int id);
	
	void save(Department department);
	
	void remove(Department department);
}
