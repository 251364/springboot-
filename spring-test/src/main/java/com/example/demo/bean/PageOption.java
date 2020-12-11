package com.example.demo.bean;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PageOption {

	private Object pd ;      //封装一个PageData对象，主要是为了能够方便进行检索功能
	
	
	
}
