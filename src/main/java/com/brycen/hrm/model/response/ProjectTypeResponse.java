package com.brycen.hrm.model.response;

import com.brycen.hrm.model.ProjectType;

public class ProjectTypeResponse {
	private int id;
	private String type;
	public ProjectTypeResponse(ProjectType type) {
		super();
		this.id = type.getId();
		this.type = type.getType();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
