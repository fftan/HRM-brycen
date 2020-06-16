package com.brycen.hrm.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.brycen.hrm.model.Employee;
import com.brycen.hrm.model.EmployeeRole;
import com.brycen.hrm.model.request.CreateEmployeeRequest;
import com.brycen.hrm.model.response.EmployeeResponse;
import com.brycen.hrm.service.EmployeeService;

@CrossOrigin
@RestController
public class EmployeeController {

	private EmployeeService empService;

	@Autowired
	public EmployeeController(EmployeeService empService) {
		this.empService = empService;
	}
	
	@GetMapping("/employees")
	public Page<EmployeeResponse> getAll(@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		PageRequest pageRequest = PageRequest.of(page - 1, size);
		Page<Employee> pageResult = empService.findAllEmployees(pageRequest);

		List<EmployeeResponse> employees = pageResult.stream().map(EmployeeResponse::new).collect(Collectors.toList());
		return new PageImpl<>(employees, pageRequest, pageResult.getTotalElements());
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
	public ResponseEntity<CreateEmployeeRequest> createEmployee(@RequestBody CreateEmployeeRequest empRequest) {
		empService.save(empRequest);
		return new ResponseEntity<>(empRequest, HttpStatus.CREATED);
	}

//	@PutMapping(value = "/employees/{id}")
//	public ResponseEntity<CreateEmployeeRequest> updateEmployee(@PathVariable("id") int id, @RequestBody CreateEmployeeRequest empRequest) {
//		Optional<Employee> currentEmployee = empService.findById(id);
//		Optional<EmployeeRole> currentEmpRole = empService.fin
//		if (!currentEmployee.isPresent()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		currentEmployee.get().setFull_name(empRequest.emp.getFull_name());
//		currentEmployee.get().setUsername(empRequest.emp.getUsername());
//		currentEmployee.get().setBirthday(empRequest.emp.getBirthday());
//		currentEmployee.get().setId_card(empRequest.emp.getId_card());
//		currentEmployee.get().setGender(empRequest.emp.isGender());
//		currentEmployee.get().setPhone(empRequest.emp.getPhone());
//		currentEmployee.get().setEmail(empRequest.emp.getEmail());
//		currentEmployee.get().setPosition(empRequest.emp.getPosition());
//		currentEmployee.get().setAddress(empRequest.emp.getAddress());
//		currentEmployee.get().setStatus(empRequest.emp.getStatus());
//		currentEmployee.get().setDepartment(empRequest.emp.getDepartment());
//		
//		empService.save(empRequest);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
}
