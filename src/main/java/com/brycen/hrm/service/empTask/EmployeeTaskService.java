package com.brycen.hrm.service.empTask;

import java.util.List;
import java.util.Optional;

import com.brycen.hrm.model.empTask.EmployeeTask;

public interface EmployeeTaskService {
	List<EmployeeTask> findAll();
	
	Optional<EmployeeTask> findById(int id);
	
	void save(EmployeeTask empTask);
	
	void remove(EmployeeTask empTask);
}
