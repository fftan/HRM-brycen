package com.brycen.hrm.model.response;

import com.brycen.hrm.model.empRole.Permission;

public class PermissionResponse {
	private int id;
	private String name;
	private String description;

	public PermissionResponse(Permission permission) {
		super();
		this.id = permission.getId();
		this.name = permission.getName();
		this.description = permission.getDescription();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
