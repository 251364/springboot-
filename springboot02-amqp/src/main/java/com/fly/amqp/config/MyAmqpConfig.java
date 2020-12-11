package com.fly.amqp.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//RabbitTemplate 给RabbitMQ发送和接收消息的
//为了让发送的数据以JSON方式发送，默认用JDK序列化方式发送
/*点开RabbitTemplate --> MessageConverter -->查看其实现方法(右键)，找到JSON实现的方法既Jackson2JsonMessageConverter 
 可以根据这个更改*/

@Configuration
public class MyAmqpConfig {

	
	@Bean
	public MessageConverter messageConverter() {
		
		//因为RabbitTemplate自动加上自己设置的MessageConverter，所以不需要重写一些内容
		return new Jackson2JsonMessageConverter() ;
	}
	
}
