package com.fly.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fly.cache.bean.Employee;
import com.fly.cache.service.EmployeeService;

@RestController
public class EmployeeController {
 @Autowired
	EmployeeService employeeservice;
	
	@GetMapping("/emp/{id}")
	public Employee  getEmployee(@PathVariable("id") Integer id) {
		
		return employeeservice.getEmp(id);
	}
	
	
	
	
	@GetMapping("/emp")
	public Employee update(Employee employee) {
	Employee emp1=	employeeservice.upEmp(employee);
	return emp1;	
	}
	
	
	@GetMapping("/del")
	public String deleteEmp( Integer id) {
		employeeservice.deleteEmp(id);
		return"删除成功";
	}
	
	@GetMapping("/emp/lastname/{lastName}")
	public Employee  getEmpBylastName(@PathVariable("lastName") String lastName) {
	
		return employeeservice.getEmpByLastName(lastName);
	}
	
}
