package com.brycen.hrm.model.request;

import java.sql.Date;

import com.brycen.hrm.model.department.Department;
import com.brycen.hrm.model.employee.Employee;
import com.brycen.hrm.model.employee.Status;

public class EmployeeRequest {
	private String username;
	private String full_name;
	private int id_card;
	private Date birthday;
	private boolean gender;
	private String phone;
	private String email;
	private String position;
	private String address;
	private int department;
	private int status;

	public EmployeeRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeRequest(Employee emp) {
		super();
		this.username = emp.getUsername();
		this.full_name = emp.getFull_name();
		this.id_card = emp.getId_card();
		this.birthday = emp.getBirthday();
		this.gender = emp.isGender();
		this.phone = emp.getPhone();
		this.email = emp.getEmail();
		this.position = emp.getPosition();
		this.address = emp.getAddress();
		this.department = emp.getDepartment().getId();
		this.status = emp.getStatus().getId();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public int getId_card() {
		return id_card;
	}

	public void setId_card(int id_card) {
		this.id_card = id_card;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
