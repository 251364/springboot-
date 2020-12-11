package com.fly.elastic;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
 * SpringBoot默认支持两种技术来和ES交互   //可以在spring-boot-autoconfigure包中查找elasticsearch
 * 1.Jest(默认不生效)
 **   需要导入jest工具包(import io.searchbox.client.JestClient;)
 * 2.SpringData ElasticSearch(注意版本要和springboot版本适配)
 *    1)、节点信息 Client 、ClusterNodes、ClusterName
 *    2)、ElasticsearchTemplate操作ES
 *    3)、编写一个ElasticsearchRepository的子接口来操作ES
 *    两种用法：在github中搜索Spring找到spring-data-elasticsearch，根据模板进行演示
 *    (1)编写一个ElasticsearchRepository
 */



@SpringBootApplication
public class Springboot03ElasticApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot03ElasticApplication.class, args);
	}

}
