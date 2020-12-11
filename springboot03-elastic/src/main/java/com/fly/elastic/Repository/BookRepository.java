package com.fly.elastic.Repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.fly.elastic.bean.Book;

public interface BookRepository extends ElasticsearchRepository<Book,Integer>{


public List<Book> findByBookNameLike(String bookName);
	
	
}
