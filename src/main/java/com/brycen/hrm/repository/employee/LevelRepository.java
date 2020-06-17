package com.brycen.hrm.repository.employee;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.brycen.hrm.model.employee.Level;

@Repository
public interface LevelRepository extends PagingAndSortingRepository<Level, Integer>{

}
