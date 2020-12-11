package com.fly.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fly.cache.bean.Department;
import com.fly.cache.service.DeptService;

@RestController
public class DeptController {

	@Autowired
	DeptService deptService;
	
	@RequestMapping("/dept/{id}")
	public Department getDept(@PathVariable("id") Integer id) {
		
		return deptService.getDeptById(id);
		
		
	}
}
