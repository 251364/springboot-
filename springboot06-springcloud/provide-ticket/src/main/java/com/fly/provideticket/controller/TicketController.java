package com.fly.provideticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fly.provideticket.service.TicketService;

@RestController
public class TicketController {
   
	@Autowired
	TicketService  ticketService;
	@GetMapping("/aa")
	public String getTicket() {
		
   return ticketService.getTicket();
	}
}
