package com.brycen.hrm.model.response;

import java.util.List;

import com.brycen.hrm.model.EmployeeSkill;
import com.brycen.hrm.model.Skill;

public class SkillResponse {
	private int id;
	private String name;
	private List<EmployeeSkill> employee_skill;

	public SkillResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SkillResponse(Skill skill) {
		super();
		this.id = skill.getId();
		this.name = skill.getName();
		this.employee_skill = skill.getEmployee_skill();
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

	public List<EmployeeSkill> getEmployee_skill() {
		return employee_skill;
	}

	public void setEmployee_skill(List<EmployeeSkill> employee_skill) {
		this.employee_skill = employee_skill;
	}
}
