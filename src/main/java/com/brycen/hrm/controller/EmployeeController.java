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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.brycen.hrm.model.Employee;
import com.brycen.hrm.model.object.EmployeeSkillObject;
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
	public ResponseEntity<EmployeeSkillObject> createEmployee(@RequestBody EmployeeSkillObject empSkillObj, UriComponentsBuilder builder) {
		
			empService.save(empSkillObj);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/employees/{id}").buildAndExpand(empSkillObj.emp.getId()).toUri());
		return new ResponseEntity<>(empSkillObj, HttpStatus.CREATED);
	}

//	@PutMapping(value = "/employees/{id}")
//	public ResponseEntity<EmployeeSkillObject> updateEmployee(@PathVariable("id") int id, @RequestBody EmployeeSkillObject empSkillObj) {
//		Optional<Employee> currentEmployee = empService.findById(id);
//		if (!currentEmployee.isPresent()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		currentEmployee.get().setFull_name(empSkillObj.emp.getFull_name());
//		currentEmployee.get().setUsername(empSkillObj.emp.getUsername());
//		currentEmployee.get().setBirthday(empSkillObj.emp.getBirthday());
//		currentEmployee.get().setId_card(empSkillObj.emp.getId_card());
//		currentEmployee.get().setGender(empSkillObj.emp.isGender());
//		currentEmployee.get().setPhone(empSkillObj.emp.getPhone());
//		currentEmployee.get().setEmail(empSkillObj.emp.getEmail());
//		currentEmployee.get().setPosition(empSkillObj.emp.getPosition());
//		currentEmployee.get().setStatus(empSkillObj.emp.getStatus());
//		currentEmployee.get().setDepartment(empSkillObj.emp.getDepartment());
//		currentEmployee.get().setRole(empSkillObj.emp.getRole());
//		
//		empService.save(empSkillObj);
//		return new ResponseEntity<>(currentEmployee.get(), HttpStatus.OK);
//	}
}
