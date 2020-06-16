package com.brycen.hrm.model.response;

import com.brycen.hrm.model.Role;

public class RoleResponse {
	private int id;
	private String name;
	
	public RoleResponse(Role role) {
		super();
		this.id = role.getId();
		this.name = role.getName();
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
}
