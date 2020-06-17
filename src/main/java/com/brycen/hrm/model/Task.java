package com.brycen.hrm.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(scope = Task.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "task")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@JsonBackReference(value = "project-type")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_id")
	private ProjectType type;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "task")
	private List<EmployeeTask> employee_task;

	public Task() {
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

	public List<EmployeeTask> getEmployee_task() {
		return employee_task;
	}

	public void setEmployee_task(List<EmployeeTask> employee_task) {
		this.employee_task = employee_task;
	}
}
