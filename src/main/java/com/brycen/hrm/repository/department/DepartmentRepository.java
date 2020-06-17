package com.brycen.hrm.repository.department;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.brycen.hrm.model.department.Department;

@Repository
public interface DepartmentRepository extends PagingAndSortingRepository<Department, Integer>{

}
