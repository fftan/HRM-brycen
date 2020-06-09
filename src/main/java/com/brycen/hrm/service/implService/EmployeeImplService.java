package com.brycen.hrm.service.implService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.brycen.hrm.model.Employee;
import com.brycen.hrm.repository.EmployeeRepository;
import com.brycen.hrm.service.EmployeeService;

@Service
public class EmployeeImplService implements EmployeeService {
	private EmployeeRepository empRep;

	@Autowired
	public EmployeeImplService(EmployeeRepository empRep) {
		this.empRep = empRep;
	}

	@Override
	public Page<Employee> findAllEmployees(Pageable pageable) {
		return empRep.findAll(pageable);
	}

	@Override
	public Optional<Employee> findById(int id) {
		return empRep.findById(id);
	}

	@Override
	public void save(Employee emp) {
		empRep.save(emp);
	}

	@Override
	public void remove(Employee emp) {
		empRep.delete(emp);
	}

}
