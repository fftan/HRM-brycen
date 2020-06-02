package com.brycen.hrm.service.implService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brycen.hrm.model.EmployeeTask;
import com.brycen.hrm.repository.EmployeeTaskRepository;
import com.brycen.hrm.service.EmployeeTaskService;

@Service
public class EmployeeTaskImplService implements EmployeeTaskService{
	private EmployeeTaskRepository empTaskRep;

	@Autowired
	public EmployeeTaskImplService(EmployeeTaskRepository empTaskRep) {
		this.empTaskRep = empTaskRep;
	}
	
	@Override
	public List<EmployeeTask> findAll() {
		List<EmployeeTask> empTasks = (List<EmployeeTask>) empTaskRep.findAll();
		return empTasks;
	}

	@Override
	public Optional<EmployeeTask> findById(int id) {
		Optional<EmployeeTask> empTask = empTaskRep.findById(id);
		return empTask;
	}

	@Override
	public void save(EmployeeTask empTask) {
		empTaskRep.save(empTask);
	}

	@Override
	public void remove(EmployeeTask empTask) {
		empTaskRep.delete(empTask);
	}
}
