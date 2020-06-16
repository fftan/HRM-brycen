package com.brycen.hrm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brycen.hrm.model.Employee;
import com.brycen.hrm.model.Task;
import com.brycen.hrm.model.response.DashboardResponse;
import com.brycen.hrm.service.EmployeeService;
import com.brycen.hrm.service.TaskService;
import com.fasterxml.jackson.core.JsonParser;

@CrossOrigin
@RestController
public class DashboardController {
	private TaskService taskService;
	private EmployeeService empService;

	@Autowired
	public DashboardController(TaskService taskService, EmployeeService empService) {
		super();
		this.taskService = taskService;
		this.empService = empService;
	}

	@GetMapping("/dashboard")
	public ResponseEntity<DashboardResponse> dashboard() {
		List<Task> sumProject = taskService.findAllTasks();
		List<Employee> sumEmployee = empService.findAllEmployees();
		DashboardResponse dashboard = new DashboardResponse(sumProject, sumEmployee);
		
		return new ResponseEntity<>(dashboard, HttpStatus.OK);
	}
}
