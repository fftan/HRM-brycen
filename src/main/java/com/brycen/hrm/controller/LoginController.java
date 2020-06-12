package com.brycen.hrm.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brycen.hrm.model.Employee;
import com.brycen.hrm.model.request.LoginRequest;
import com.brycen.hrm.service.LoginService;

@CrossOrigin
@RestController
public class LoginController {
	private LoginService loginService;
	
	@Autowired
	public LoginController(LoginService loginService) {
		super();
		this.loginService = loginService;
	}

	@GetMapping("/login")
	public ResponseEntity<Employee> login(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password ){
		Optional<Employee> emp = loginService.findUsername(username);
		boolean compare = emp.get().getPassword().equalsIgnoreCase(password);
		if(emp.isPresent() && compare == true) {
			return new ResponseEntity<>(emp.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
