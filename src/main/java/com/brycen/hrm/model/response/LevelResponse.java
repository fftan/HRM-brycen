package com.brycen.hrm.model.response;

import com.brycen.hrm.model.employee.Level;

public class LevelResponse {
	private int id;
	private String name;
	private String description;

	public LevelResponse(Level level) {
		super();
		this.id = level.getId();
		this.name = level.getName();
		this.description = level.getDescription();
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
