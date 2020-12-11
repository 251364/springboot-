package com.fly.amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*自动配置
 * 1.RabbitAutoConfiguration下面简绍这个类中都有啥
 * 2.有自动配置连接工厂ConnectionFactory
 * 3.RabbitProperties封装了RabbitMQ的配置
 * 4.RabbitTemplate 给RabbitMQ发送和接收消息的
 * 5.AmqpAdmin是RabbitMQ的系统管理组件，他不来发收消息，用来创建，删除队列，创建交换器等。
 * 6.@EnableRabbit  +@RabbitListener监听消息队列的内容
 * 
 * 
 * 
 * 
 * 
 * 
 * */

@EnableRabbit    //开启基于注解的RabbitMQ模式
@SpringBootApplication
public class Springboot02AmqpApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot02AmqpApplication.class, args);
	}

}
