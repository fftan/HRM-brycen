package com.brycen.hrm.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "level")
public class Level implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	
	@JsonManagedReference("empSkill_level")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "level")
	private List<EmployeeSkill> employee_skill;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<EmployeeSkill> getEmployee_skill() {
		return employee_skill;
	}

	public void setEmployee_skill(List<EmployeeSkill> employee_skill) {
		this.employee_skill = employee_skill;
	}
}
