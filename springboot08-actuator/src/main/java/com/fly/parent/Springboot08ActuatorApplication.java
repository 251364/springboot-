package com.fly.parent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*自定义健康状态的指示器（搜RedisHealthIndicator类看源码）
 *  1.编写一个指示器实现HealthIndictor接口
 *  2.指示器名字xxxHealthIndicator
 *  3.加入容器中
 * 
 * 
 * 
 * 
 */




@SpringBootApplication
public class Springboot08ActuatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot08ActuatorApplication.class, args);
	}

}
