package com.fly.consumeuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
public class UserController {
   
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/buy")
	public String  buyTicket(String name) {
		//url地址是在localhost：8761 上找的
	String template=restTemplate.getForObject("http://PROVID-NAME/aa", String.class);
		return name +"购买了"+template;
	}
	
	
	
}
