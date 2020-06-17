package com.brycen.hrm.service.department;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.brycen.hrm.model.department.Department;

public interface DepartmentService {
	Page<Department> findAllDepartments(Pageable pageable);
	
	List<Department> listAll();
	
	Optional<Department> findById(int id);
	
	void save(Department department);
	
	void remove(Department department);
}
