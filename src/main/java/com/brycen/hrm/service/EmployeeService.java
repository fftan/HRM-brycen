package com.brycen.hrm.service;

import java.util.List;
import java.util.Optional;

import com.brycen.hrm.model.Employee;

public interface EmployeeService {
	List<Employee> findAllEmployees();
	
	Optional<Employee> findById(int id);
	
	void save(Employee empempSkill);
	
	void remove(Employee emp);
}
