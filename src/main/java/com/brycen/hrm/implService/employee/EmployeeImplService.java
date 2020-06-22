package com.brycen.hrm.implService.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brycen.hrm.model.employee.Employee;
import com.brycen.hrm.model.request.CreateEmployeeRequest;
import com.brycen.hrm.model.request.EmployeeRequest;
import com.brycen.hrm.repository.empRole.EmployeeRoleRepository;
import com.brycen.hrm.repository.employee.EmployeeRepository;
import com.brycen.hrm.service.employee.EmployeeService;

@Service
public class EmployeeImplService implements EmployeeService {
	private EmployeeRepository empRep;
	private EmployeeRoleRepository empRoleRep;

	@Autowired
	public EmployeeImplService(EmployeeRepository empRep, EmployeeRoleRepository empRoleRep) {
		this.empRep = empRep;
		this.empRoleRep = empRoleRep;
	}

	@Override
	public Page<Employee> findAllEmployees(Pageable pageable) {
		return empRep.findAll(pageable);
	}

	@Override
	public Optional<Employee> findById(int id) {
		return empRep.findById(id);
	}

	@Transactional
	@Override
	public void save(CreateEmployeeRequest empRequest) {
		// save to employee table
		empRep.save(empRequest.emp);
		// get id from record saved
		Optional<Employee> employee = empRep.findByUsername(empRequest.emp.getUsername());
		int employee_id = employee.get().getId();
		// save to employee_role table
		empRequest.emp_role.getEmployee().setId(employee_id);;
		empRoleRep.save(empRequest.emp_role);
	}

	@Override
	public void update(int id, EmployeeRequest empRequest) {
		Optional<Employee> currentEmployee = empRep.findById(id);
		currentEmployee.get().setFull_name(empRequest.getFull_name());
		currentEmployee.get().setUsername(empRequest.getUsername());
		currentEmployee.get().setBirthday(empRequest.getBirthday());
		currentEmployee.get().setId_card(empRequest.getId_card());
		currentEmployee.get().setGender(empRequest.isGender());
		currentEmployee.get().setPhone(empRequest.getPhone());
		currentEmployee.get().setEmail(empRequest.getEmail());
		currentEmployee.get().setPosition(empRequest.getPosition());
		currentEmployee.get().setAddress(empRequest.getAddress());
		currentEmployee.get().getStatus().setId(empRequest.getStatus());;
		currentEmployee.get().getDepartment().setId(empRequest.getDepartment());;
		empRep.save(currentEmployee.get());
	}

	@Override
	public void remove(Employee emp) {
		empRep.delete(emp);
	}

//	Dashboard
	@Override
	public List<Employee> findAllEmployees() {
		return (List<Employee>) empRep.findAll();
	}

}
