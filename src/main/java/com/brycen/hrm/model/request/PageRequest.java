package com.brycen.hrm.model.request;

public class PageRequest {
	private int page;
	private int size;

	public PageRequest(int page, int size) {
		super();
		this.page = page;
		this.size = size;
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
}
