package com.fly.consumeuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//开启发现功能
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumeUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumeUserApplication.class, args);
	}
     
	 @LoadBalanced //使用负载均衡机制
	 @Bean
	 //帮我们发送http请求的
	public RestTemplate restTemplate() {  
		
		return new RestTemplate();
	}
}
