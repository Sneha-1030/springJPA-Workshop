package com.cybage.controller;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
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
			//empService.createEmployee(new Employee());
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
		
		@RequestMapping(path= "/getemployee/{name}", method = RequestMethod.GET)
		public ModelAndView getEmployee(@PathVariable String name) {
			
			log.info("Inside first controller");
			ModelAndView mv = new ModelAndView("employee","emp", empService.findEmployeebyName(name));
			return mv;
		}
		
//		@RequestMapping(path = "/getemployee/{id}", method = RequestMethod.GET)
//		public ModelAndView getEmployeeById(@PathVariable long id) {
//	         
//			Optional<Employee> employee = empService.getEmpById(id);
//			ModelAndView mv;
//			log.info("Employee Id: "+ id);
//			if(employee.getId() != 0) {
//				 mv=new ModelAndView("employee","emp",employee);
//				 return mv;
//			} else {
//				mv = new ModelAndView("noemp", "message", "Employee Not Found..!!!");
//				return mv;}
//			}
			
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
				empService.createEmployee(employee);
	
				log.info("Inside post create controller");
				
				ModelAndView mv=new ModelAndView("allemp","employees",empService.getAllEmployee());
				return mv;
			}
			
			
			
			//Update Employee
			@RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
			public ModelAndView editEmployee(@PathVariable long id) {
//                Employee employee = (Employee) empService.getEmpById(id);
				
				log.info("Update Employee");
				ModelAndView mv = new ModelAndView("updateemp","emp",empService.getEmpById(id));
				return mv;
				
			}

			@RequestMapping(path = "/update", method = RequestMethod.POST)
			public ModelAndView updateEmployee(@ModelAttribute Employee employee) {
		
//				log.info(employee);
//				Optional<Employee> emp = (empService).editEmployee(employee,employee.getId());
	
				log.info("Inside post update controller");
				empService.createEmployee(employee);
				ModelAndView mv=new ModelAndView("allemp","employees",empService.getAllEmployee());
				return mv;
			}
			
			
			
		    //Delete Employee
		    @RequestMapping(path="/delete/{id}",method=RequestMethod.GET)
		    public ModelAndView deleteEmployee(@PathVariable int id) {
		    	Optional<Employee> emp=empService.getEmpById(id);
		        empService.deleteEmployee(emp.get());
		        ModelAndView mv=new ModelAndView("allEmp","employees",empService.getAllEmployee());
		        return mv;
		    }
}

//
//@Controller
//public class EmployeeController {
//
//
//
//   Logger log=LogManager.getLogger();
////    @Autowired
////    EmployeeService employeeService;
//    
//    @Autowired
//    EmployeeServ employeeServ;
//    
//    @RequestMapping(path="/employee",method=RequestMethod.GET)
//    public ModelAndView getAllEmployee() {
//        ModelAndView mv=new ModelAndView("allEmp","employees",employeeServ.getAllEmployee());
//        return mv;
//    }
//
//
//
//   
//    @RequestMapping(path="/getemployee",method=RequestMethod.GET)
//    public ModelAndView showEmployee() {
//        Employee employee=new Employee(101,"Sam","Manager");
//        log.info("Inside First Controller");
//        ModelAndView mv=new ModelAndView("employee","emp",employee);
//        return mv;
//    }
//    @RequestMapping(path="/getemployee/{id}",method=RequestMethod.GET)
//    public ModelAndView getEmployeeById(@PathVariable long id) {
////        Employee employee=employeeService.getEmpById(id);
//        Optional<Employee> employee=employeeServ.getEmpById(id);
//        ModelAndView mv;
//        log.info("Employee Id: "+id);
//        if(employee.getEid()!=0) {
//            mv=new ModelAndView("employee","emp",employee);
//            return mv;
//        }
//        else {
//            mv=new ModelAndView("noemp","message","Employee Not Found!!");
//            return mv;
//        }
//
//
//
//   }
////    @RequestMapping(path="/getemployeename",method=RequestMethod.GET)
////    public ModelAndView getEmployeeByName(@RequestParam String name) {
////        Employee employee=employeeService.getEmpByName(name);
////        ModelAndView mv;
////        log.info("Employee Name: "+employee.getEid());
////        if(employee.getEid()!=0) {
////            mv=new ModelAndView("employee","emp",employee);
////            return mv;
////        }
////        else {
////            mv=new ModelAndView("noemp","message","Employee Not Found!!");
////            return mv;
////        }
////
////    }
//    
//    //Create Employee
//    @RequestMapping(path="/create",method=RequestMethod.GET)
//    public ModelAndView addEmployee() {
//        Employee employee=new Employee();
//        log.info("Inside get create controller");
//        ModelAndView mv=new ModelAndView("createEmployee","emp",employee);
//        return mv;
//    }
//    @RequestMapping(path="/create",method=RequestMethod.POST)
//    public ModelAndView createEmployee(@ModelAttribute Employee employee) {
//        Employee emp=employeeServ.createEmployee(employee);
//        log.info("Inside post create controller");
//        ModelAndView mv=new ModelAndView("allEmp","employees",employeeServ.getAllEmployee());
//        return mv;
//    }
//    
//    //Update Employee
//    @RequestMapping(path="/edit/{id}",method=RequestMethod.GET)
//    public ModelAndView editEmployee(@PathVariable long id) {
//        Optional<Employee> employee=employeeServ.getEmpById(id);
//        ModelAndView mv=new ModelAndView("updateEmployee","emp",employee);
//        return mv;
//    }
//    @RequestMapping(path="/edit",method=RequestMethod.POST)
//    public ModelAndView updateEmployee(@ModelAttribute  Employee employee) {
//        employeeServ.updateEmployee(employee,employee.getEid());
//        ModelAndView mv=new ModelAndView("allEmp","employees",employeeServ.getAllEmployee());
//        return mv;
//    }
//    
//    //Delete Employee
//    @RequestMapping(path="/delete/{id}",method=RequestMethod.GET)
//    public ModelAndView deleteEmployee(@PathVariable int id) {
//        employeeServ.deleteEmployee(id);
//        ModelAndView mv=new ModelAndView("allEmp","employees",employeeServ.getAllEmployee());
//        return mv;
//    }
//}
