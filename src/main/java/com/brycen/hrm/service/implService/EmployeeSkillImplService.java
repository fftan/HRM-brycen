package com.brycen.hrm.service.implService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brycen.hrm.model.EmployeeSkill;
import com.brycen.hrm.repository.EmployeeSkillRepository;
import com.brycen.hrm.service.EmployeeSkillService;

@Service
public class EmployeeSkillImplService implements EmployeeSkillService{
	private EmployeeSkillRepository empSkillRep;

	@Autowired
	public EmployeeSkillImplService(EmployeeSkillRepository empSkillRep) {
		this.empSkillRep = empSkillRep;
	}

	@Override
	public List<EmployeeSkill> findAll() {
		List<EmployeeSkill> empSkills = empSkillRep.findAll();
		return empSkills;
	}

	@Override
	public Optional<EmployeeSkill> findById(int id) {
		Optional<EmployeeSkill> empSkill = empSkillRep.findById(id);
		return empSkill;
	}

	@Override
	public void save(EmployeeSkill empSkill) {
		empSkillRep.save(empSkill);
	}

	@Override
	public void remove(EmployeeSkill empSkill) {
		empSkillRep.delete(empSkill);
	}
}
