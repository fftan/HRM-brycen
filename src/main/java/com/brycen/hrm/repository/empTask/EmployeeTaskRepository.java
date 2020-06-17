package com.brycen.hrm.repository.empTask;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brycen.hrm.model.empTask.EmployeeTask;

@Repository
public interface EmployeeTaskRepository extends JpaRepository<EmployeeTask, Integer>{

}
