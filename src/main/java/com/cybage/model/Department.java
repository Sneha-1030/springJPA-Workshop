package com.cybage.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="department")

public class Department {

	@Id
	private long id;
	private String department;
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Department(long id, String department) {
		super();
		this.id = id;
		this.department = department;
	}
	
	
	
	
}
