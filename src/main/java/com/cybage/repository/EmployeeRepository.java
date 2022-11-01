package com.cybage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cybage.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


  List<Employee> findByName(String name);
}

