package com.brycen.hrm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="cms")
public class Cms implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String screen_name;
	private String content_header;
	private String content_main;
	private String content_sider;
	private String content_footer;
	private int person_id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date create_date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getScreen_name() {
		return screen_name;
	}
	public void setScreen_name(String screen_name) {
		this.screen_name = screen_name;
	}
	public String getContent_header() {
		return content_header;
	}
	public void setContent_header(String content_header) {
		this.content_header = content_header;
	}
	public String getContent_main() {
		return content_main;
	}
	public void setContent_main(String content_main) {
		this.content_main = content_main;
	}
	public String getContent_sider() {
		return content_sider;
	}
	public void setContent_sider(String content_sider) {
		this.content_sider = content_sider;
	}
	public String getContent_footer() {
		return content_footer;
	}
	public void setContent_footer(String content_footer) {
		this.content_footer = content_footer;
	}
	
	public int getPerson_id() {
		return person_id;
	}
	
	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}
	
	public Date getCreate_date() {
		return create_date;
	}
	
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
}
