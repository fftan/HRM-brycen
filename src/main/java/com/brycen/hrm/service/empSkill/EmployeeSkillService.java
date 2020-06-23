package com.brycen.hrm.service.empSkill;

import java.util.List;
import java.util.Optional;

import com.brycen.hrm.model.empSkill.EmployeeSkill;
import com.brycen.hrm.model.request.EmployeeSkillRequest;

public interface EmployeeSkillService {
	List<EmployeeSkill> findAll();

	Optional<EmployeeSkill> findById(int id);

	Optional<EmployeeSkill> findByEmployeeId(int id);

	void save(EmployeeSkillRequest empSkill);
	
	void update(EmployeeSkillRequest empSkillRequest);

	void remove(EmployeeSkill empSkill);
}
