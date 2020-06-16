package com.brycen.hrm.service.implService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brycen.hrm.model.Employee;
import com.brycen.hrm.repository.LoginRepository;
import com.brycen.hrm.service.LoginService;

@Service
public class LoginImplService implements LoginService{
	private LoginRepository loginRep;

	@Autowired
	public LoginImplService(LoginRepository loginRep) {
		super();
		this.loginRep = loginRep;
	}

	@Override
	public Optional<Employee> findUsername(String username) {
		return loginRep.findByUsername(username);
	}

}
