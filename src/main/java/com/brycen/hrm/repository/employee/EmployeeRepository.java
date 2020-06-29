package com.brycen.hrm.repository.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.brycen.hrm.model.employee.Employee;
import com.brycen.hrm.model.request.EmployeeParamRequest;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {
	Optional<Employee> findByUsername(String username);
}
