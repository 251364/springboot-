package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.bean.PageOption;
import com.example.demo.bean.ProductOrder;
import com.example.demo.mapper.ProductOrderMapper;
import com.example.demo.service.ProductOrderService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductOrderServiceImpl implements ProductOrderService{

	private final ProductOrderMapper productOrdermapper;

	@Override
	public PageOption selectPage(long currentPage, long pageSize, ProductOrder productOrder) {
		long startNum = (currentPage - 1) * pageSize;
		List<ProductOrder> prod = productOrdermapper.selectPage(startNum, pageSize, productOrder);		
		PageOption page = new PageOption();
		page.setPd(prod);
		return page;
	}

	@Override
	public ProductOrder getProductOrderByOrderId(Long id) {
		// TODO Auto-generated method stub
		return productOrdermapper.getProductOrderByOrderId(id);
	}
	
	
	
	
	
	
	
	
}
