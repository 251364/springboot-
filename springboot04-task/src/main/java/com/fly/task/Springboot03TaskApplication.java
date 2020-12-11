package com.fly.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

//开启异步任务
@EnableAsync
//开启基于注解的定时任务
@EnableScheduling
@SpringBootApplication
public class Springboot03TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot03TaskApplication.class, args);
	}

}
