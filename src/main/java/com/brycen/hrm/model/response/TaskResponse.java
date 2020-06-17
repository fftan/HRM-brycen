package com.brycen.hrm.model.response;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.brycen.hrm.model.ProjectType;
import com.brycen.hrm.model.Task;

public class TaskResponse {
	private int id;
	private String name;
	private String description;
	private String estimate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date start_date;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date end_date;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date create_date;
	
	private ProjectType type;
	
	

	public TaskResponse(Task task) {
		super();
		this.id = task.getId();
		this.name = task.getName();
		this.description = task.getDescription();
		this.estimate = task.getEstimate();
		this.start_date = task.getStart_date();
		this.end_date = task.getEnd_date();
		this.create_date = task.getCreate_date();
		this.type = task.getType();
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

	public String getEstimate() {
		return estimate;
	}

	public void setEstimate(String estimate) {
		this.estimate = estimate;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public ProjectType getType() {
		return type;
	}

	public void setType(ProjectType type) {
		this.type = type;
	}
}
