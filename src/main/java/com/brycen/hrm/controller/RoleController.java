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

import com.brycen.hrm.model.Role;
import com.brycen.hrm.model.response.RoleResponse;
import com.brycen.hrm.service.RoleService;

@CrossOrigin
@RestController
public class RoleController {
	private RoleService roleService;

	@Autowired
	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}
	
	@GetMapping(value = "/roles")
	public Page<RoleResponse> findAllRoles(@RequestParam(name = "page", defaultValue = "1") int page, @RequestParam(name = "size", defaultValue = "5") int size){
		PageRequest pageRequest = PageRequest.of(page - 1, size);
		Page<Role> pageResult = roleService.findAllRole(pageRequest);
		List<RoleResponse> roles = pageResult.stream().map(RoleResponse::new).collect(Collectors.toList());
		return new PageImpl<>(roles, pageRequest, pageResult.getTotalElements());
	}
	
	@GetMapping(value = "/roles/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Role> findRoleById(@PathVariable("id") int id){
		Optional<Role> role = roleService.findRoleById(id);
		if(!role.isPresent()) {
			return new ResponseEntity<>(role.get(),HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(role.get(),HttpStatus.OK);
	}
	
	@PostMapping(value = "/roles/create")
	public ResponseEntity<Role> createRole(@RequestBody Role role, UriComponentsBuilder builder){
		roleService.save(role);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/roles/{id}").buildAndExpand(role.getId()).toUri());
		return new ResponseEntity<>(role, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/roles/{id}")
	public ResponseEntity<Role> updateRole(@PathVariable("id") int id, @RequestBody Role role ){
		Optional<Role> currentRole = roleService.findRoleById(id);
		if(!currentRole.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		currentRole.get().setName(role.getName());
		roleService.save(currentRole.get());
		return new ResponseEntity<>(currentRole.get(), HttpStatus.OK);
	}
}
