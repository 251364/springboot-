package com.fly.ticket.service;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;

//在发布的时候用dubbo的service
/*import org.springframework.stereotype.Service;*/
//将服务放到容器里面
@Component
@Service//将服务发布出去
public class TicketServiceImpl implements TicketService{
  @Override
	public String getTicket() {
		
		return "购票";
	}

}
