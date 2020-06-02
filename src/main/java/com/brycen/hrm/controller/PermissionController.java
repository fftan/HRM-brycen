package com.brycen.hrm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.brycen.hrm.model.Permission;
import com.brycen.hrm.service.PermissionService;

@CrossOrigin
@RestController
public class PermissionController {
	private PermissionService perService;

	@Autowired
	public PermissionController(PermissionService perService) {
		this.perService = perService;
	}
	
	@GetMapping(value = "/permissions")
	public ResponseEntity<List<Permission>> findAllPermission(){
		List<Permission> permissions = perService.findAllPermission();
		if (permissions.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(permissions, HttpStatus.OK);
	}
	
	@GetMapping(value = "/permissions/{id}")
	public ResponseEntity<Permission> findPermissionById(@PathVariable("id") int id){
		Optional<Permission> permission = perService.findPermissionById(id);
		if(!permission.isPresent()) {
			return new ResponseEntity<>(permission.get(),HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(permission.get(),HttpStatus.OK);
	}
	
	@PostMapping(value = "/permissions/create")
	public ResponseEntity<Permission> createPermission(@RequestBody Permission permission, UriComponentsBuilder builder){
		perService.save(permission);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/permissions/{id}").buildAndExpand(permission.getId()).toUri());
		return new ResponseEntity<>(permission, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/permissions/{id}")
	public ResponseEntity<Permission> updatePermission(@PathVariable("id") int id, @RequestBody Permission permission ){
		Optional<Permission> currentPermission = perService.findPermissionById(id);
		if(!currentPermission.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		currentPermission.get().setName(permission.getName());
		currentPermission.get().setLevel(permission.getLevel());
		currentPermission.get().setDescription(permission.getDescription());
		perService.save(currentPermission.get());
		return new ResponseEntity<>(currentPermission.get(), HttpStatus.OK);
	}
}
