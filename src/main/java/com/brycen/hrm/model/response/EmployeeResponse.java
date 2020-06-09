package com.brycen.hrm.model.response;

import java.sql.Date;
import java.util.List;

import com.brycen.hrm.model.Employee;
import com.brycen.hrm.model.EmployeeSkill;

public class EmployeeResponse {
	private int id;
	private String full_name;
	private int id_card;
	private Date birthday;
	private boolean gender;
	private String phone;
	private String email;
	private String position;
	private String status;
	private String department;
	private List<EmployeeSkill> employee_skill;

	public EmployeeResponse() {
		super();
	}

	public EmployeeResponse(Employee emp) {
		super();
		this.id = emp.getId();
		this.full_name = emp.getFull_name();
		this.id_card = emp.getId_card();
		this.birthday = emp.getBirthday();
		this.gender = emp.isGender();
		this.phone = emp.getPhone();
		this.email = emp.getEmail();
		this.position = emp.getPosition();
		this.status = emp.getStatus().getName();
		this.department = emp.getDepartment().getName();
		this.employee_skill = emp.getEmployee_skill();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<EmployeeSkill> getEmployee_skill() {
		return employee_skill;
	}

	public void setEmployee_skill(List<EmployeeSkill> employee_skill) {
		this.employee_skill = employee_skill;
	}
}
