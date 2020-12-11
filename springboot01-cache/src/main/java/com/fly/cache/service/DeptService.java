package com.fly.cache.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;
import com.fly.cache.bean.Department;
import com.fly.cache.mapper.DepartmentMapper;
@Service
public class DeptService {
	@Autowired
	DepartmentMapper  departmentMapper;
  
	//指定id为departmentCacheManager缓存管理器
	@Qualifier("departmentCacheManager")
	@Autowired
	RedisCacheManager departmentCacheManager;
	
	/*
缓存能存入redis
第二次查询就不能反序列化回来，浏览器上再查一次，会出现页面错误
存储的dept的json数据；我们重写的配置类MyRedisConfig默认用的RedisTemplate<Object, Employee>
只能把Employee的反序列化
加入继续配置department的也配置Config，就可以了反序列化了，在MyRedisConfig类加入配置

*/
	
	//必须指定配置的cacheManager否则不知道是哪一个
	@Cacheable(cacheNames="dept",cacheManager="departmentCacheManager")
	//这都是基于注解缓存
/*	public Department getDeptById(Integer id) {
		System.out.println("查询id为"+id+"部门");
		Department department =departmentMapper.getDeptById(id);
		return department;
		
	}*/
	
	
	
	//用编码方式缓存，加上 @Autowired 
	//                    RedisCacheManager departmentCacheManager;
	public Department getDeptById(Integer id) {
		System.out.println("查询id为"+id+"部门");
		Department department =departmentMapper.getDeptById(id);
		//获取缓存名字为"dept"的缓存，就可以为缓存中操作数据
        Cache dept=departmentCacheManager.getCache("dept");
        dept.put("dept:1", "department");
		return department;
		
	}
	
}
