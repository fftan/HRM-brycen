package com.brycen.hrm.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.brycen.hrm.model.Employee;

public interface EmployeeService {
	Page<Employee> findAllEmployees(Pageable pageable);

	Optional<Employee> findById(int id);

	void save(Employee emp);

	void remove(Employee emp);
}
