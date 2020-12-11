package com.fly.ticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*1.将服务提供者注册到注册中心
 *    1.引入dubbo和zkclient（zookeeper）相关依赖
 *    2.配置dubbo扫描包和注册
 *    3.使用@Service发布服务
 *
 */

@SpringBootApplication
public class SpringbootTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTicketApplication.class, args);
	}

}
