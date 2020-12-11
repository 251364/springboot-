package cn.spring.mybatis.mapper;

import org.springframework.stereotype.Repository;

import cn.spring.mybatis.bean.videoFile;

//@Mapper或者@MapperScan将接口扫描装配到容器中
/*
 * 
 * @Mapper和@Repository区别
 * 
 * 
 * @Mapper 是 Mybatis 的注解，和 Spring 没有关系，
 * @Repository 是 Spring 的注解，用于声明一个 Bean
 相同点
两个都是注解在Dao上

回到顶部
不同
@Repository需要在Spring中配置扫描地址，然后生成Dao层的Bean才能被注入到Service层中。

@Mapper不需要配置扫描地址，通过xml里面的namespace里面的接口地址，生成了Bean后注入到Service层中。
@Mapper 一定要有，否则 Mybatis 找不到 mapper。
@Repository 可有可无，可以消去依赖注入的报错信息。
@MapperScan 可以替代 @Mapper*/



@Repository
public interface FilesMapper {
	public videoFile getFilesById(int id);

	public videoFile getFilesByChannelId(String channelid);

	public int insertFiles(videoFile files);

	public int updateFiles(videoFile files);
}
