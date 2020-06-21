package com.brycen.hrm.repository.empSkill;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brycen.hrm.model.empSkill.EmployeeSkill;

@Repository
public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Integer>{
	Optional<EmployeeSkill> findByEmployeeId(int id);
}
