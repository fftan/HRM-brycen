package com.brycen.hrm.service.employee;

import java.util.Optional;

import com.brycen.hrm.model.employee.Employee;

public interface LoginService {
	Optional<Employee> findUsername(String username); 
}
