package com.brycen.hrm.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.brycen.hrm.model.Department;

public interface DepartmentService {
	Page<Department> findAllDepartments(Pageable pageable);
	
	Optional<Department> findById(int id);
	
	void save(Department department);
	
	void remove(Department department);
}
