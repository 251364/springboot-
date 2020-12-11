package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.bean.ProductOrder;

public interface ProductOrderMapper {

	List<ProductOrder> selectPage(@Param("currentPage")long currentPage,
			                      @Param("pageSize")long pageSize,
			                      @Param("productOrder")ProductOrder productOrder);
	ProductOrder  getProductOrderByOrderId(Long id);


}
