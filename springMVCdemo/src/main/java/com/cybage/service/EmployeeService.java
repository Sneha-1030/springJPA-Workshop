package com.cybage.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cybage.model.Employee;

@Service
public class EmployeeService {

	List<Employee> employees;
	Employee emp = new Employee();
	
	public EmployeeService() {
		employees = new ArrayList<>();
		employees.add(new Employee(102,"Shreya","QA"));
	}
	
	public Employee getEmpById(long l) {
	
		employees.stream().filter(e -> e.getId()==l).forEach(res->this.emp=res);
		return emp;
		
	}

	public Employee getEmpByName(String name) {
		emp=new Employee();
		employees.stream().filter(e -> e.getName().equals(name)).forEach(res->this.emp=res);
		return emp;
	}
	
	public Employee createEmployee(Employee emp) {
		employees.add(emp);
		return emp;
	}

	public List<Employee> getAllEmployee() {
		
		return employees;
	}

	public Employee editEmployee(Employee emp, long id) {
		employees.set(employees.indexOf(getEmpById(id)), emp);
		
		return emp;
		
	}
	
	public void deleteEmployee(int id) {
        employees.remove(getEmpById(id));
    }

	
}
