package com.brycen.hrm.service;

import java.util.List;
import java.util.Optional;

import com.brycen.hrm.model.Employee;
import com.brycen.hrm.model.EmployeeSkill;
import com.brycen.hrm.model.object.EmployeeSkillObject;

public interface EmployeeService {
	List<Employee> findAllEmployees();
	
	Optional<Employee> findById(int id);
	
	void save(EmployeeSkillObject empSkillObj);
	
	void remove(Employee emp);
}
