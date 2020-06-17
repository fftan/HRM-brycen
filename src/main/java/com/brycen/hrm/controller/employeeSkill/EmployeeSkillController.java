package com.brycen.hrm.controller.employeeSkill;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.brycen.hrm.model.empSkill.EmployeeSkill;
import com.brycen.hrm.service.empSkill.EmployeeSkillService;

@CrossOrigin
@RestController
public class EmployeeSkillController {
	private EmployeeSkillService empSkillSerivce;

	@Autowired
	public EmployeeSkillController(EmployeeSkillService empSkillSerivce) {
		this.empSkillSerivce = empSkillSerivce;
	}

	@GetMapping(value = "/employee-skill")
	public ResponseEntity<List<EmployeeSkill>> getAll() {
		List<EmployeeSkill> empSkill = empSkillSerivce.findAll();
		if (empSkill.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(empSkill, HttpStatus.OK);
	}

	@GetMapping(value = "/employee-skill/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeSkill> getById(@PathVariable("id") int id) {
		Optional<EmployeeSkill> empSkill = empSkillSerivce.findById(id);
		if (!empSkill.isPresent()) {
			return new ResponseEntity<EmployeeSkill>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<EmployeeSkill>(empSkill.get(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/employee-skill/create")
	public ResponseEntity<EmployeeSkill> createNew(@RequestBody EmployeeSkill empSkill, UriComponentsBuilder builder){
		empSkillSerivce.save(empSkill);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("employee-skill/{id}").buildAndExpand(empSkill.getId()).toUri());
		return new ResponseEntity<EmployeeSkill>(empSkill, HttpStatus.CREATED);
	}
}
