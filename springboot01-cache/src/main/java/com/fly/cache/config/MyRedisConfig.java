package com.fly.cache.config;

import java.net.UnknownHostException;
import java.util.List;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizers;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.fly.cache.bean.Department;
import com.fly.cache.bean.Employee;


@Configuration
public class MyRedisConfig {
	
	
	
	
	
     //配置Employee的缓存管理
	//RedisAutoConfiguration中查找相对配置，实现redis JSON输出
	//redis存储JSON序列化
	@Bean
	public RedisTemplate<Object, Employee> empRedisTemplate(
			RedisConnectionFactory redisConnectionFactory)
					throws UnknownHostException {
		RedisTemplate<Object, Employee> template = new RedisTemplate<Object, Employee>();
		template.setConnectionFactory(redisConnectionFactory);
		//目的就是让redis数据库中显示数据不是jdk序列化的字符串，而是变成JSON显示出具体显示数据
		//默认jdk序列化,我们在这变成JSON的序列化 ，Jackson2JsonRedisSerializer继承RedisSerializer序列化
		Jackson2JsonRedisSerializer<Employee> a=new Jackson2JsonRedisSerializer<Employee>(Employee.class);
		
		template.setDefaultSerializer(a);
		return template;
	}
	
	//CacheConfiguration中   RedisCacheConfiguration查找配置，实现缓存redis JSON输出
	//缓存管理器
	
	@Bean                                                          //是上面配置的empRedisTemplate方法
	public RedisCacheManager employeeCacheManager(RedisTemplate<Object, Employee> empRedisTemplate) {
		RedisCacheManager cacheManager = new RedisCacheManager(empRedisTemplate);
		//多了一个前缀默认将CacheName作为key的前缀
		cacheManager.setUsePrefix(true);
	    return cacheManager;
		
	}
	
	
	
	//配置Department类的缓存管理
	//RedisAutoConfiguration中查找相对配置，实现redis JSON输出
	//redis存储JSON序列化
	@Bean
	public RedisTemplate<Object, Department> depRedisTemplate(
			RedisConnectionFactory redisConnectionFactory)
					throws UnknownHostException {
		RedisTemplate<Object, Department> template= new RedisTemplate<Object, Department>();
		template.setConnectionFactory(redisConnectionFactory);
		//目的就是让redis数据库中显示数据不是jdk序列化的字符串，而是变成JSON显示出具体显示数据
		//默认jdk序列化,我们在这变成JSON的序列化 ，Jackson2JsonRedisSerializer继承RedisSerializer序列化
		Jackson2JsonRedisSerializer<Department> a=new Jackson2JsonRedisSerializer<Department>(Department.class);
		
		template.setDefaultSerializer(a);
		return template;
	}
	
	
	//CacheConfiguration中   RedisCacheConfiguration查找配置，实现缓存redis JSON输出
	//缓存管理器
	@Bean                                                          //是上面配置的empRedisTemplate方法
	public RedisCacheManager departmentCacheManager(RedisTemplate<Object, Department> depRedisTemplate) {
		RedisCacheManager cacheManager = new RedisCacheManager(depRedisTemplate);
		//多了一个前缀默认将CacheName作为key的前缀
		cacheManager.setUsePrefix(true);
	    return cacheManager;
		
	}
	
	

	
	//@Primary   有多个cacheManager必须有一个默认的缓存管理器,否则报错，
		
		
		@Primary
		@Bean
		public RedisCacheManager cacheManager(RedisTemplate<Object, Object> redisTemplate) {
			RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
			cacheManager.setUsePrefix(true);
			
			
			return cacheManager;
		}
}
