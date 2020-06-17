package com.brycen.hrm.model.response;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.brycen.hrm.model.employee.Status;

public class StatusResponse {
	private int id;
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date change_date;

	public StatusResponse(Status status) {
		super();
		this.id = status.getId();
		this.name = status.getName();
		this.change_date = status.getChange_date();
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

	public Date getChange_date() {
		return change_date;
	}

	public void setChange_date(Date change_date) {
		this.change_date = change_date;
	}
}
