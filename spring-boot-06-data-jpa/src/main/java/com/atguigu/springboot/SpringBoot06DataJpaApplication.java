package com.atguigu.springboot;

import javax.persistence.EntityManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.querydsl.jpa.impl.JPAQueryFactory;

@SpringBootApplication
public class SpringBoot06DataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot06DataJpaApplication.class, args);	
	}
	@Bean
	public JPAQueryFactory jpaQueryFactory(EntityManager entityManager) {
		return new JPAQueryFactory(entityManager);
	}
}
