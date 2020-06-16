package com.brycen.hrm.model.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.brycen.hrm.model.Department;
import com.brycen.hrm.model.Employee;

public class DepartmentResponse {
	private int id;
	private String name;

	private boolean active;
	private int persion_id;

	@Temporal(value = TemporalType.TIMESTAMP)
	private Date create_date;
//	private List<Employee> employee;

	public DepartmentResponse(Department dep) {
		super();
		this.id = dep.getId();
		this.name = dep.getName();
		this.active = dep.isActive();
		this.persion_id = dep.getPersion_id();
		this.create_date = dep.getCreate_date();
//		List<Employee> emp = new ArrayList<Employee>();
//		for(int i=0; i<emp.size(); i++) {
//			emp.get(i).getFull_name();
//			this.employee = emp;
//		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getPersion_id() {
		return persion_id;
	}

	public void setPersion_id(int persion_id) {
		this.persion_id = persion_id;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
}
