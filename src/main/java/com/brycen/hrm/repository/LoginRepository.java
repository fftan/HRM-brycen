package com.brycen.hrm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brycen.hrm.model.Employee;

@Repository
public interface LoginRepository extends JpaRepository<Employee, Integer>{
	Optional<Employee> findByUsername(String username);
}
