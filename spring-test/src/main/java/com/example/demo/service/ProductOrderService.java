package com.example.demo.service;



import com.example.demo.bean.PageOption;
import com.example.demo.bean.ProductOrder;

public interface ProductOrderService {

 PageOption selectPage(long currentPage,long pageSize,ProductOrder productOrder);
 ProductOrder getProductOrderByOrderId(Long id);
		
	
}
