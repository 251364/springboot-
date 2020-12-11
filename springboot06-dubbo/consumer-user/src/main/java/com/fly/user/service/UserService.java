package com.fly.user.service;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fly.ticket.service.TicketService;

@Service
public class UserService {
 //远程引用注解
	@Reference
	TicketService ticketService;
	public void hello() {
		
		String  ticket=ticketService.getTicket();
		System.out.println("国庆大家都要;"+ticket);
		
		
	}
}
