package com.fly.cache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.fly.cache.bean.Employee;
import com.fly.cache.mapper.EmployeeMapper;

//cacheNames="emp" 下面方法中所有value="emp"就可以都不用写了
@CacheConfig(cacheNames="emp",cacheManager="employeeCacheManager")//所有缓存的公共配置
@Service
public class EmployeeService {

	@Autowired
	EmployeeMapper employeemapper;
/*将方法的运行结果进行缓存*/   /*condition="#id>1"和#a0>1一样*/
	@Cacheable(value="emp",key="#id"/*{"123","1234"}*//*,key="myKeyGenerator"*//*,condition="#id>1",unless="#a0==2"*//*,异步sync=true*/)
	public Employee getEmp(Integer id) {
		
		System.out.println("查询");
		Employee aa = employeemapper.getEmpById(id);
		return aa;
	}
 
	
	
/*	@CachePut 既调用方法又更新缓存数据
 * 将方法的返回值放到缓存
 * 
 * 查询1号员工还是没更新之前的，说明【1号员工缓存中没更新，但是第一次查的时候放进缓存了，所以还是查的之前的】
 *   改成@CachePut(value="emp",key="#employee.id")使用emplyee的ID
 *      或者 @CachePut(value="emp",key="#result.id")使用返回后的ID
 * @Cacheable的key不能用#result,因为他是在方法运行之前先等到key，检查缓存
 * 
  */
	
	@CachePut(value="emp",key="#employee.id")

	public Employee upEmp(Employee employee) {
		System.out.println("updateEmp"+employee);
	employeemapper.updateEmp(employee);
		return employee;
		
	}
	
	/*
	  @CachEvict 缓存清除

value	缓存的名称，在 spring 配置文件中定义，必须指定至少一个	例如：
@Cacheable(value=”mycache”) 或者 
@Cacheable(value={”cache1”,”cache2”}

key
	缓存的 key，可以为空，如果指定要按照 SpEL 表达式编写，如果不指定，则缺省按照方法的所有参数进行组合	例如：
@Cacheable(value=”testcache”,key=”#userName”)

condition	缓存的条件，可以为空，使用 SpEL 编写，返回 true 或者 false，只有为 true 才进行缓存/清除缓存，在调用方法之前之后都能判断	例如：
@Cacheable(value=”testcache”,condition=”#userName.length()>2”)

allEntries
(@CacheEvict )	是否清空所有缓存内容，缺省为 false，如果指定为 true，则方法调用后将立即清空所有缓存	例如：
@CachEvict(value=”testcache”,allEntries=true)

beforeInvocation
(@CacheEvict)	是否在方法执行前就清空，缺省为 false，如果指定为 true，则在方法还没有执行的时候就清空缓存，缺省情况下，如果方法执行抛出异常，则不会清空缓存	例如：
@CachEvict(value=”testcache”，beforeInvocation=true)

unless
(@CachePut)
(@Cacheable)	用于否决缓存的，不像condition，该表达式只在方法执行之后判断，此时可以拿到返回值result进行判断。条件为true不会缓存，fasle才缓存	例如：
@Cacheable(value=”testcache”,unless=”#result == null”)	 
	 */
	@CacheEvict(value="emp"/*,key="#id"*/,/*allEntries=true*/beforeInvocation=true)
	public void deleteEmp(Integer id) {
		
		System.out.println("删除id是"+id+"员工");
		int i=10/0;
		//employeemapper.deleteEmpById(id);
	}
	
	
	
	
/*//比较复杂时候用@Caching ，可以指定多个注解，包含了	
	Cacheable[] cacheable() default {};

	CachePut[] put() default {};

	CacheEvict[] evict() default {};*/

	
	
	@Caching(
		cacheable= {
				@Cacheable(value="emp",key="#lastname")
		},
		//@CachePut, 执行，若果用@Cacheable(value="emp",key="#lastname")还是会查数据库
		//但是用@CachePut(value="emp",key="#result.id"), id在查一次就不查询了，直接在缓存中查
		put= {
		        @CachePut(value="emp",key="#result.id"),	
		        @CachePut(value="emp",key="#result.email")
		}
		)
	
public Employee getEmpByLastName(String lastname) {
		
		System.out.println("根据lastname查询emplee信息");
		return	employeemapper.getEmpByLastName(lastname);
		 
	}
	

 
}
