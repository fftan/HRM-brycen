package com.brycen.hrm.repository.employee;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brycen.hrm.model.employee.Employee;

@Repository
public interface LoginRepository extends JpaRepository<Employee, Integer>{
	Optional<Employee> findByUsername(String username);
}
