package com.brycen.hrm.model.response;

import java.util.List;

import com.brycen.hrm.model.empTask.Task;
import com.brycen.hrm.model.employee.Employee;

public class DashboardResponse {
	private List<Task> task;
	private List<Employee> emp;
	
	public DashboardResponse(List<Task> sumProject, List<Employee> sumEmployee) {
		this.emp = sumEmployee;
		this.task = sumProject;
	}

	public List<Task> getTask() {
		return task;
	}

	public void setTask(List<Task> task) {
		this.task = task;
	}

	public List<Employee> getEmp() {
		return emp;
	}

	public void setEmp(List<Employee> emp) {
		this.emp = emp;
	}
	
}
