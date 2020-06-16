package com.brycen.hrm.service;

import java.util.Optional;

import com.brycen.hrm.model.Employee;

public interface LoginService {
	Optional<Employee> findUsername(String username); 
}
