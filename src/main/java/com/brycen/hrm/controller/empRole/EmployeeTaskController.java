package com.brycen.hrm.controller.empRole;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.brycen.hrm.model.empTask.EmployeeTask;
import com.brycen.hrm.service.empTask.EmployeeTaskService;

@CrossOrigin
@RestController
public class EmployeeTaskController {
	private EmployeeTaskService empTaskService;

	@Autowired
	public EmployeeTaskController(EmployeeTaskService empTaskService) {
		this.empTaskService = empTaskService;
	}

	@GetMapping(value = "/employee-task")
	public ResponseEntity<List<EmployeeTask>> getAll() {
		List<EmployeeTask> empTasks = empTaskService.findAll();
		if (empTasks.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(empTasks, HttpStatus.OK);
	}

	@GetMapping(value = "/employee-task/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeTask> getById(@PathVariable("id") int id) {
		Optional<EmployeeTask> empTask = empTaskService.findById(id);
		if (!empTask.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(empTask.get(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/employee-task/create")
	public ResponseEntity<EmployeeTask> createNew(@RequestBody EmployeeTask empTask, UriComponentsBuilder builder){
		empTaskService.save(empTask);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/employee-task/{id}").buildAndExpand(empTask.getId()).toUri());
		return new ResponseEntity<EmployeeTask>(empTask, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/employee-task/update")
	public ResponseEntity<EmployeeTask> update(@PathVariable("id") int id, @RequestBody EmployeeTask empTask){
		Optional<EmployeeTask> currentEmpTask = empTaskService.findById(id);
		if(!currentEmpTask.isPresent()) {
			return new ResponseEntity<EmployeeTask>(HttpStatus.NO_CONTENT);
		}
		currentEmpTask.get().setEmployee(empTask.getEmployee());
		currentEmpTask.get().setTask(empTask.getTask());
		empTaskService.save(currentEmpTask.get());
		return new ResponseEntity<EmployeeTask>(currentEmpTask.get(), HttpStatus.OK);
	}
}
