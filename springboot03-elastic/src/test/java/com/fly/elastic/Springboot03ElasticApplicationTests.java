package com.fly.elastic;


import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fly.elastic.Repository.BookRepository;
import com.fly.elastic.bean.Article;
import com.fly.elastic.bean.Book;

import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot03ElasticApplicationTests {

	
	@Autowired
	JestClient jestClient;
	
	@Autowired
	BookRepository  bookRepository;
	
	@Test
	public void test02() {
		/*
		 * Book book=new Book();
		 * book.setId(2122);
		 * book.setAuthor("吴承恩");
		 * book.setBookName("西游记"); bookRepository.index(book );
		 */
		
		
	for(Book book:	bookRepository.findByBookNameLike("游")) {
		
		System.out.println(book);
	}
	}
	
	
	
	
	
	
	//jestClient.execute 执行操作
	
	
	//创建
	
	@Test
	public void contextLoads() {
		Article article=new Article();
		article.setId(1);
		article.setTitle("好消息");
		article.setAuthor("张三");
		article.setContent("hello world");
		//建立一个索引功能
      Index index=new Index.Builder(article).index("suoyin").type("news").build();
		try {
			jestClient.execute(index);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//查询
	@Test
	public void search() {
		String   json="{\n" + 
				"    \"query\" : {\n" + 
				"        \"match\" : {\n" + 
				"            \"content\" : \"hello\"\n" + 
				"        }\n" + 
				"    }\n" + 
				"}";
		
		
		
  Search search=new Search.Builder(json).addIndex("suoyin").addType("news").build();
		
  try {
SearchResult result=	jestClient.execute(search);
System.out.println(result.getJsonString());
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  
	}
	
	
	
	
	
	

}
