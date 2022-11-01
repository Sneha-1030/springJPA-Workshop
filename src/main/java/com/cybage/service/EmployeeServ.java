package com.cybage.service;

import java.util.List;
import java.util.Optional;

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
  
  //create
  public Employee createEmployee(Employee emp) {
//	  Employee emp = new Employee(101,"Sneha","Admin");
	  employeeRepository.save(emp);
	  return emp;
  }
  
  //update
  public Optional<Employee> getEmpById(long id) {
	  Optional<Employee> emp = employeeRepository.findById((long) id);
	  return emp;
	  }
//  public Optional<Employee> editEmployee(Employee employee, long id) {
//		Optional<Employee> emp=employeeRepository.findById((long) id);
//		  return emp;
//	}
//  
  
  
  //delete
  public void deleteEmployee(Employee emp) {
	  employeeRepository.delete(emp); 
  }
//
//public Object getEmpById(long id) {
//    Employee employee = employeeRepository.getById(id);
//	return null;
//}

 public List<Employee> findEmployeebyName(String name) {
	 
	 return employeeRepository.findByName(name);
 }








}
