package com.fly.amqp.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.fly.amqp.bean.Book;

@Service
public class BookService {

	
	//可以直接用Book对象收消息
	@RabbitListener(queues="atguigu.news")
	public void receice(Book  book) {
		
		System.out.println("收到消息"+book);
		
	}
	//可以直接用Message来接受消息，可以得到消息头，消息体
	@RabbitListener(queues="atguigu")
	public void receice02(Message  message) {
		
		System.out.println("消息体"+message.getBody());
		System.out.println("消息头"+message.getMessageProperties());
	}
	
}
