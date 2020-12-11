package com.fly.amqp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fly.amqp.bean.Book;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot02AmqpApplicationTests {

	@Autowired
	RabbitTemplate  rabbitTemplate;
	
	
	//假如没有队列，交换器，绑定，用来创建
	@Autowired
	AmqpAdmin amqpAdmin;
	
/*1.单播(点对点)	
 *direct exchange
 * 
 * */
	
	//发送消息
	@Test
	public void contextLoads() {
		//Message 需要自己构造，定义消息内容和消息头，点击message进入可以查看
		//rabbitTemplate.send(exchange, routingKey, message);
		
		//object默认当成消息体，只要需要传入要发送的对象，自动序列化发送给rabbitmq
		//rabbitTemplate.convertAndSend(exchange, routingKey, object);
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("msg","这是要发送的数据消息");
		map.put("data", Arrays.asList("hello","word","123","true"));
		//对象被默认序列化后发送出去，所以网页上http://localhost:15672显示会出现一串字符串
		//rabbitTemplate.convertAndSend("exchange.direct", "atguigu.news", map);
		rabbitTemplate.convertAndSend("exchange.direct", "atguigu.news", new Book("西游记","吴承恩"));
	}
   
	//接受消息
	
	@Test
	public void receive() {
		
	Object o=	rabbitTemplate.receiveAndConvert("atguigu.news");
		System.out.println(o.getClass());
		System.out.println(o);
	}
	
	
	
	
	/*广播
	 * 
	 * fanout exchange
	 * */
	@Test
	public void sendMsg() {
		
		//在这routingKey值可以随便写
		rabbitTemplate.convertAndSend("exchange.fanout", "routingKey", new Book("红楼梦","曹雪芹"));
		
	}
	
	
	@Test
	public void createExchange() {
		
		//创建哪一种类型的Exchange，点击Exchange进入，点开其实现，包含有TopicExchange，DirectExchange.......等
		//       
		//amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange") );
		//System.out.println("创建完成");
		
		
		//创建队列
		//amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));
		
		//创建绑定Binding
		amqpAdmin.declareBinding(new Binding("amqpadmin.queue",Binding.DestinationType.QUEUE ,"amqpadmin.exchange" , "amqp.haha", null));
		
	}
	
	
	
}
