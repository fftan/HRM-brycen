package com.brycen.hrm.service.implService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.brycen.hrm.model.Employee;
import com.brycen.hrm.model.EmployeeSkill;
import com.brycen.hrm.model.object.EmployeeSkillObject;
import com.brycen.hrm.repository.EmployeeRepository;
import com.brycen.hrm.repository.EmployeeSkillRepository;
import com.brycen.hrm.service.EmployeeService;

@Service
public class EmployeeImplService implements EmployeeService {
	private EmployeeRepository empRep;
	private EmployeeSkillRepository empSkillRep;

	@Autowired
	public EmployeeImplService(EmployeeRepository empRep, EmployeeSkillRepository empSkillRep) {
		this.empRep = empRep;
		this.empSkillRep = empSkillRep;
	}

	@Override
	public List<Employee> findAllEmployees() {
		return (List<Employee>) empRep.findAll();
	}

	@Override
	public Optional<Employee> findById(int id) {
		return empRep.findById(id);
	}

	@Transactional
	@Override
	public void save(EmployeeSkillObject empSkillObj) {
		var countSkill = empSkillObj.empSkill.size();
		empRep.save(empSkillObj.emp);
		for (int i = 0; i < countSkill; i++) {
			empSkillRep.save(empSkillObj.empSkill.get(i));
		}
	}

	@Override
	public void remove(Employee emp) {
		empRep.delete(emp);
	}
}
