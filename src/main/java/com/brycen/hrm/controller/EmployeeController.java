package com.brycen.hrm.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.brycen.hrm.model.Employee;
import com.brycen.hrm.service.EmployeeService;

@CrossOrigin
@RestController
public class EmployeeController {

	private EmployeeService empService;

	@Autowired
	public EmployeeController(EmployeeService empService) { 
		this.empService = empService;
	}

	@GetMapping(value = "/employees")
	public ResponseEntity<List<Employee>> findAllEmployees() {

		List<Employee> empls = empService.findAllEmployees();
		if (empls.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(empls, HttpStatus.OK);
	}

	@GetMapping(value = "/employees/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {
		Optional<Employee> emp = empService.findById(id);
		if (!emp.isPresent()) {
			return new ResponseEntity<>(emp.get(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(emp.get(), HttpStatus.OK);
	}

	@PostMapping(value = "/employees/create")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp, UriComponentsBuilder builder) {
		empService.save(emp);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/employees/{id}").buildAndExpand(emp.getId()).toUri());
		return new ResponseEntity<>(emp, HttpStatus.CREATED);
	}

	@PutMapping(value = "/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody Employee emp) {
		Optional<Employee> currentEmployee = empService.findById(id);
		if (!currentEmployee.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		currentEmployee.get().setFull_name(emp.getFull_name());
		currentEmployee.get().setUsername(emp.getUsername());
		currentEmployee.get().setBirthday(emp.getBirthday());
		currentEmployee.get().setId_card(emp.getId_card());
		currentEmployee.get().setGender(emp.isGender());
		currentEmployee.get().setPhone(emp.getPhone());
		currentEmployee.get().setEmail(emp.getEmail());
		currentEmployee.get().setPosition(emp.getPosition());
		currentEmployee.get().setStatus(emp.getStatus());
		currentEmployee.get().setDepartment(emp.getDepartment());
		currentEmployee.get().setRole(emp.getRole());

		empService.save(currentEmployee.get());
		return new ResponseEntity<>(currentEmployee.get(), HttpStatus.OK);
	}
}
