package com.brycen.hrm.service.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.brycen.hrm.model.employee.Employee;
import com.brycen.hrm.model.request.CreateEmployeeRequest;
import com.brycen.hrm.model.request.EmployeeRequest;

public interface EmployeeService {
	Page<Employee> findAllEmployees(Pageable pageable);
	
	List<Employee> findAllEmployees();

	Optional<Employee> findById(int id);

	void save(CreateEmployeeRequest empRequest);
	
	void update(int id, EmployeeRequest empRequest);

	void remove(Employee emp);
}
