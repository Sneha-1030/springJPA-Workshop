package com.cybage.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "ems_employee")
public class Employee {

	@Id
	private long id;
	private String name;
	private String department;
	
	
	public Employee() {
		super();
	}


    public Employee(long id, String name, String department) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + "]";
	}


	

	
}
