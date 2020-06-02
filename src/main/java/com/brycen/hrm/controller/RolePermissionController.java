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

import com.brycen.hrm.model.RolePermission;
import com.brycen.hrm.service.RolePermissionService;

@CrossOrigin
@RestController
public class RolePermissionController {
	private RolePermissionService rolePerService;

	@Autowired
	public RolePermissionController(RolePermissionService rolePerService) {
		this.rolePerService = rolePerService;
	}
	
	@GetMapping(value = "/role-permission")
	public ResponseEntity<List<RolePermission>> getAll() {
		List<RolePermission> rolePers =  rolePerService.findAll();
		if(rolePers.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(rolePers, HttpStatus.OK);
	}
	
	@GetMapping(value = "/role-permission/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RolePermission> getById(@PathVariable("id") int id){
		Optional<RolePermission> rolePer = rolePerService.findById(id);
		if(!rolePer.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(rolePer.get(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/role-permission/create")
	public ResponseEntity<RolePermission> createNew(@RequestBody RolePermission rolePer, UriComponentsBuilder builder){
		rolePerService.save(rolePer);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/role-permission/{id}").buildAndExpand(rolePer.getId()).toUri());
		return new ResponseEntity<RolePermission>(rolePer, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/role-permission/update")
	public ResponseEntity<RolePermission> update(@PathVariable("id") int id, @RequestBody RolePermission rolePer){
		Optional<RolePermission> currentRolePer = rolePerService.findById(id);
		if(!currentRolePer.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		currentRolePer.get().setRole(rolePer.getRole());
		currentRolePer.get().setPermission(rolePer.getPermission());
		rolePerService.save(currentRolePer.get());
		return new ResponseEntity<>(currentRolePer.get(), HttpStatus.OK);
	}
}
