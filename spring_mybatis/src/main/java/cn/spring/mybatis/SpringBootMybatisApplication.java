package cn.spring.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*@RequestMapping可以指定GET、POST请求方式
@GetMapping等价于@RequestMapping的GET请求方式*/

//扫描mapper包，并注解为@mapper
@MapperScan(value = "cn.spring.mybatis.mapper")
@SpringBootApplication
public class SpringBootMybatisApplication {
	static Logger logger = LoggerFactory.getLogger(SpringBootMybatisApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMybatisApplication.class, args);
		logger.info("日志文件能启动成功吗 !");
	}
}
