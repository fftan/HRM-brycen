package com.brycen.hrm.service;

import java.util.List;
import java.util.Optional;

import com.brycen.hrm.model.EmployeeTask;

public interface EmployeeTaskService {
	List<EmployeeTask> findAll();
	
	Optional<EmployeeTask> findById(int id);
	
	void save(EmployeeTask empTask);
	
	void remove(EmployeeTask empTask);
}
