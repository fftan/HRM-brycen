package com.brycen.hrm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.brycen.hrm.model.Department;

@Repository
public interface DepartmentRepository extends PagingAndSortingRepository<Department, Integer>{

}
