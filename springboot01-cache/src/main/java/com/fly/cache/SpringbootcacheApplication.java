 package com.fly.cache;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
/*自动配置类CacheAutoConfiguration 
 * 
 * 所有缓存
 * 	import org.springframework.boot.autoconfigure.cache.CaffeineCacheConfiguration;
import org.springframework.boot.autoconfigure.cache.CouchbaseCacheConfiguration;
import org.springframework.boot.autoconfigure.cache.EhCacheCacheConfiguration;
import org.springframework.boot.autoconfigure.cache.GenericCacheConfiguration;
import org.springframework.boot.autoconfigure.cache.HazelcastCacheConfiguration;
import org.springframework.boot.autoconfigure.cache.InfinispanCacheConfiguration;
import org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration;
import org.springframework.boot.autoconfigure.cache.NoOpCacheConfiguration;
import org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration;
import org.springframework.boot.autoconfigure.cache.SimpleCacheConfiguration; //默认的
 * 
 * 
 * 
默认使用缓存是 ConcurrentMapCacheManager==ConcurrentMapCache，将数据保存在ConcurrentMap<Object, Object> store, boolean allowNullValues
 * 开发中使用缓存中间件
 
 *1.安装redis，
 *2.引入redis的starter,既pom.xml文件引入的内容
 *3.配置redis
 *4.缓存测试
 *   原理：CacheManager==Cache缓存组件来实际给缓存CRUD 
 *    1.pom.xml引入RedisCacheConfiguration,其他缓存就不管用了，容器保存的RedisCacheManager
 *    2.RedisCacheManager帮我们创建RedisCache来作为缓存来操作Cache
 *    3.key-value都是对象都是用序列化保存的，如何保存为JSON
 *      1)引入redis的starter,CacheManager变为RedisCacheManager
 *      2)默认创建的RedisCacheManager操作的redis使用的是RedisTemplate<Object，object>
 *      3)在RedisCacheConfiguration里面模仿者写就行
 *    4.自定义CacheManager,也是写到Config里面了    
 */
@MapperScan("com.fly.cache.mapper")
@SpringBootApplication
@EnableCaching
public class SpringbootcacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootcacheApplication.class, args);
	}

}
