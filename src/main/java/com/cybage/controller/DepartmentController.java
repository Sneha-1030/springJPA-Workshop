package com.cybage.controller;

import com.cybage.model.Department;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cybage.repository.DepartmentRepository;



public class DepartmentController {

	
	@Autowired
	  DepartmentRepository departmentRepository;

	  @GetMapping("/create")
	  public ResponseEntity<List<Department>> getAllDepartment(@RequestParam(required = false) String department) {
	    List<Department> departments = new ArrayList<Department>();

	
		if (department == null)
	    	departmentRepository.findAll().forEach(departments::add);
	    else
	    	departmentRepository.deleteBydeptId(id).forEach(departments::add);

	    
	  }
}
