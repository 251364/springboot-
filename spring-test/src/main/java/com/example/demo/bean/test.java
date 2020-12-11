package com.example.demo.bean;

import java.math.BigDecimal;

public class test {

	
	public static void main(String[] args) {
		BigDecimal a=new BigDecimal(0.1);
	    int k= a.compareTo(BigDecimal.ZERO);
	    System.out.println(k);
	}
}
