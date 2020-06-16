package com.brycen.hrm.model.response;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.brycen.hrm.model.Task;

public class TaskResponse {
	private int id;
	private String name;
	private boolean offshore;
	private boolean product;
	private String description;
	private String estimate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date start_date;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date end_date;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date create_date;
	
	

	public TaskResponse(Task task) {
		super();
		this.id = task.getId();
		this.name = task.getName();
		this.offshore = task.isOffshore();
		this.product = task.isProduct();
		this.description = task.getDescription();
		this.estimate = task.getEstimate();
		this.start_date = task.getStart_date();
		this.end_date = task.getEnd_date();
		this.create_date = task.getCreate_date();
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

	public boolean isOffshore() {
		return offshore;
	}

	public void setOffshore(boolean offshore) {
		this.offshore = offshore;
	}

	public boolean isProduct() {
		return product;
	}

	public void setProduct(boolean product) {
		this.product = product;
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
}
