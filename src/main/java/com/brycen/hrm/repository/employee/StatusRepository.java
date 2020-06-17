package com.brycen.hrm.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brycen.hrm.model.employee.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer>{

}
