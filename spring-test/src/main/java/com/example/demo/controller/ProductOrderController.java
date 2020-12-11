package com.example.demo.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.ProductOrder;
import com.example.demo.service.ProductOrderService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/productOrder")
public class ProductOrderController {
      private final ProductOrderService productorderservice;

	@PostMapping("/{currentPage}/{pageSize}")
	public Object getByPage(@PathVariable("currentPage") long currentPage, @PathVariable("pageSize") long pageSize,
			@RequestBody ProductOrder productOrder) {
		return productorderservice.selectPage(currentPage, pageSize, productOrder);

	}


    @GetMapping("/{id}")
    public  ProductOrder  getById(@PathVariable("id") Long id) {
    
        return productorderservice.getProductOrderByOrderId(id);
   
}










}
