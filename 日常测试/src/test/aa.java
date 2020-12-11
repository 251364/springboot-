package test;

import java.util.Date;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

public class aa {
public static void main(String[] args) {
	Long timeMills = DateUtil.date().getTime() + (8 - 1) * 24 * 60 * 60 * 1000;
	Date date = new Date();
	date.setTime(timeMills);
	DateUtil.date(date);
	System.out.println(DateUtil.date(date));
	
	  DateTime uu=DateUtil.offsetDay( DateUtil.date(), 8-1);
	  
	  System.out.println(uu);
	
	System.out.println(uu.compareTo(DateUtil.date()));
	
}
}
