package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.model.Employee;
import com.cybage.repository.EmployeeRepository;


@Service
public class EmployeeServ {

  @Autowired
  EmployeeRepository employeeRepository;
  
  public List<Employee> getAllEmployee() {
	  return employeeRepository.findAll();
  }
  
  public Employee createEmployee(Employee emp1) {
	  Employee emp = new Employee(101,"Sneha","Admin");
	  employeeRepository.save(emp);
	  return emp;
  }

}
