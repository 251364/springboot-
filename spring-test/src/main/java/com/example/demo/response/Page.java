package com.example.demo.response;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 
 * Description: 分页
 
 */
@Data
@Accessors(chain = true)
public class Page {

	private Integer total;

	private Object rows;

}
