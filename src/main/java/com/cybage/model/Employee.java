package com.cybage.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ems_employee")
public class Employee {

	@Id
	private long id;
	private String name;
	private String desgn;
	
	
	public Employee() {
		super();
	}


    public Employee(long id, String name, String desgn) {
		super();
		this.id = id;
		this.name = name;
		this.desgn = desgn;
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


	public String getDesgn() {
		return desgn;
	}


	public void setDepartment(String desgn) {
		this.desgn = desgn;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	  @JoinColumn(name = "dept_id", nullable = false)
	  @OnDelete(action = OnDeleteAction.CASCADE)
	  @JsonIgnore
	  private Employee employee;
	
	
	
	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", desgn=" + desgn + ", employee=" + employee + "]";
	}


	


	

	
}
