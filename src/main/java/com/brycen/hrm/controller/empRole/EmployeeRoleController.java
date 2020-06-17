package com.brycen.hrm.controller.empRole;

import java.util.List;
import java.util.Optional;

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

import com.brycen.hrm.model.empRole.EmployeeRole;
import com.brycen.hrm.model.empRole.Role;
import com.brycen.hrm.service.empRole.EmployeeRoleService;

@CrossOrigin
@RestController
public class EmployeeRoleController {
	private EmployeeRoleService empRoleService;

	public EmployeeRoleController(EmployeeRoleService empRoleService) {
		super();
		this.empRoleService = empRoleService;
	}
	
	@GetMapping(value = "/employee-roles")
	public ResponseEntity<List<EmployeeRole>> findAllRoles(){
		List<EmployeeRole> roles = empRoleService.findAll();
		if (roles.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}
	
	@GetMapping(value = "/employee-roles/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeRole> findRoleById(@PathVariable("id") int id){
		Optional<EmployeeRole> role = empRoleService.findById(id);
		if(!role.isPresent()) {
			return new ResponseEntity<>(role.get(),HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(role.get(),HttpStatus.OK);
	}
	
	@PostMapping(value = "/employee-roles/create")
	public ResponseEntity<EmployeeRole> createRole(@RequestBody EmployeeRole role, UriComponentsBuilder builder){
		empRoleService.save(role);
		return new ResponseEntity<>(role, HttpStatus.CREATED);
	}
}
