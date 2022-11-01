package com.cybage.controller;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cybage.model.Employee;
import com.cybage.service.EmployeeServ;
import com.cybage.service.EmployeeService;



	@Controller
	public class EmployeeController {
		
		Logger log=org.apache.logging.log4j.LogManager.getLogger();
		@Autowired
		EmployeeService employeeService;
		
		@Autowired
		EmployeeServ empService;
		
		@RequestMapping(path = "/employee", method = RequestMethod.GET)
		public ModelAndView getEmployee() {
//			Employee employee = new Employee(101, "Sneha", "Manager");
			log.info("Inside first controller");
			empService.createEmployee(new Employee());
			ModelAndView mv=new ModelAndView("allemp","employees",empService.getAllEmployee());
			return mv;
		}
		
		@RequestMapping(path = "/getemployee", method = RequestMethod.GET)
		public ModelAndView showEmployee() {
			Employee employee = new Employee(101, "Sneha", "ENG");
			log.info("Inside first controller");
			ModelAndView mv=new ModelAndView("employee","emp",employee);
			return mv;
		}
		
		@RequestMapping(path = "/getemployee/{id}", method = RequestMethod.GET)
		public ModelAndView getEmployeeById(@PathVariable int id) {
	
			Employee employee = employeeService.getEmpById(id);
			ModelAndView mv;
			log.info("Employee Id: "+ id);
			if(employee.getId() != 0) {
				 mv=new ModelAndView("employee","emp",employee);
				 return mv;
			} else {
				mv = new ModelAndView("noemp", "message", "Employee Not Found..!!!");
				return mv;}
			}
			
			@RequestMapping(path = "/getemployeename", method = RequestMethod.GET)
			public ModelAndView getEmployeeByName(@RequestParam String name) {
		
				Employee employee = employeeService.getEmpByName(name);
				ModelAndView mv;
				log.info("Employee name: "+ employee.getName());
				if(employee.getId() != 0) {
					 mv=new ModelAndView("employee","emp",employee);
					 return mv;
				} else {
					mv = new ModelAndView("noemp", "message", "Employee Not Found..!!!");
					return mv;
				}
			}
			
			//create employee
			@RequestMapping(path = "/create", method = RequestMethod.GET)
			public ModelAndView addEmployee() {
		
				Employee employee = new Employee();
				
				log.info("Inside post create controller");
				ModelAndView mv = new ModelAndView("createEmployee","emp",employee);
				return mv;
			}
			
			@RequestMapping(path = "/create", method = RequestMethod.POST)
			public ModelAndView createEmployee(@ModelAttribute Employee employee) {
		
				log.info(employee);
				Employee emp = employeeService.createEmployee(employee);
	
				log.info("Inside post create controller");
				
				ModelAndView mv=new ModelAndView("allemp","employees",employeeService.getAllEmployee());
				return mv;
			}
			
			
			
			//Update Employee
			@RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
			public ModelAndView editEmployee(@PathVariable int id) {
                Employee employee = employeeService.getEmpById(id);
				
				log.info("Update Employee");
				ModelAndView mv = new ModelAndView("updateemp","emp",employee);
				return mv;
				
			}

			@RequestMapping(path = "/update", method = RequestMethod.POST)
			public ModelAndView editEmployee(@ModelAttribute Employee employee) {
		
				log.info(employee);
				Employee emp = employeeService.editEmployee(employee,employee.getId());
	
				log.info("Inside post update controller");
				
				ModelAndView mv=new ModelAndView("allemp","employees",employeeService.getAllEmployee());
				return mv;
			}
			
			
			
		    //Delete Employee
		    @RequestMapping(path="/delete/{id}",method=RequestMethod.GET)
		    public ModelAndView deleteEmployee(@PathVariable int id) {
		        employeeService.deleteEmployee(id);
		        ModelAndView mv=new ModelAndView("allEmp","employees",employeeService.getAllEmployee());
		        return mv;
		    }
}
