package com.brycen.hrm.model.request;

public class EmployeeParamRequest {
	private int page;
	private int size;
	private String full_name;

	public EmployeeParamRequest(int page, int size, String full_name) {
		super();
		this.page = page;
		this.size = size;
		this.full_name = full_name;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
}
