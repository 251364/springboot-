package com.fly.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.fly.cache.bean.Employee;
import com.fly.cache.mapper.EmployeeMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages="com.fly.cache")
public class SpringbootcacheApplicationTests {
	 @Autowired
	   EmployeeMapper employeemapper;
	 @Autowired
	 StringRedisTemplate stringRedisTemplates;//操作字符串的
	 @Autowired
	  RedisTemplate  redisTemplate;//操作对象的
	
	 @Autowired
	 RedisTemplate<Object, Employee> empRedisTemplate;
	 
	 
	 
	/*测试redis五大类型
	 *  stringRedisTemplates.opsForHash();
		 stringRedisTemplates.opsForList();..........
		 
	 * */
	 
	 @Test
	 public void test01() {
		 /*测试string类型
		 stringRedisTemplates.opsForValue().append("msg", "hello");
		 String msg=stringRedisTemplates.opsForValue().get("msg");
		 System.out.println(msg);*/
		 /*
		  * 测试list
		 
		stringRedisTemplates.opsForList().leftPush("mylist", "1");
		stringRedisTemplates.opsForList().leftPush("mylist", "2");*/
	
	 
	 }  
	 
	 
	 //测试保存对象
	 @Test
	 public void test02() {
		 Employee empById=employeemapper.getEmpById(1);
		 //默认保存对象，使用jdk序列化机制，序列化的数据保存到redis中
		/*redisTemplate.opsForValue().set("emp-01", empById);*/
		
		//转成JSON形式，可以重写一个配置，在config中，使保存到redis数据为JSON
		 empRedisTemplate.opsForValue().set("emp-01", empById);
	 }
	 
	 
	 
	 
	@Test
	public void contextLoads() {
		Employee aa=employeemapper.getEmpById(1);
		System.out.println(aa);
		
	}

}
