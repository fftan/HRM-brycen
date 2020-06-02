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

import com.brycen.hrm.model.Department;
import com.brycen.hrm.service.DepartmentService;

@CrossOrigin
@RestController
public class DepartmentController {
	private DepartmentService depService;

	@Autowired
	public DepartmentController(DepartmentService depService) {
		this.depService = depService;
	}

	@GetMapping(value = "/departments")
	public ResponseEntity<List<Department>> findAllDepartments() {
		List<Department> departments = depService.findAllDepartments();
		if (departments.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(departments, HttpStatus.OK);
	}
	
	@GetMapping(value = "/departments/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Department> findDepartmentById(@PathVariable("id") int id) {
		Optional<Department> department = depService.findById(id);
		if(!department.isPresent()) {
			return new ResponseEntity<>(department.get(),HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(department.get(),HttpStatus.OK);
	}
	
	@PostMapping(value = "/departments/create")
	public ResponseEntity<Department> createDepartment(@RequestBody Department department, UriComponentsBuilder builder){
		depService.save(department);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/departments/{id}").buildAndExpand(department.getId()).toUri());
		return new ResponseEntity<>(department, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/departments/{id}")
	public ResponseEntity<Department> updateDepartment(@PathVariable("id") int id, @RequestBody Department department ){
		Optional<Department> currentdepartment = depService.findById(id);
		if(!currentdepartment.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		currentdepartment.get().setName(department.getName());
		currentdepartment.get().setActive(department.isActive());
		currentdepartment.get().setCreate_date(department.getCreate_date());
		currentdepartment.get().setPersion_id(department.getPersion_id());
		depService.save(currentdepartment.get());
		return new ResponseEntity<>(currentdepartment.get(), HttpStatus.OK);
	}
}
