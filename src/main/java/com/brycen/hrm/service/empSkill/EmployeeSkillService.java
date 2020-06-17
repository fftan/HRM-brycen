package com.brycen.hrm.service.empSkill;

import java.util.List;
import java.util.Optional;

import com.brycen.hrm.model.empSkill.EmployeeSkill;

public interface EmployeeSkillService {
	List<EmployeeSkill> findAll();

	Optional<EmployeeSkill> findById(int id);

	void save(EmployeeSkill empSkill);

	void remove(EmployeeSkill empSkill);
}
