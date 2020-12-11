package io.rong.exception.error;

import java.util.Map;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

//添加web界面显示属性信息
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

	  public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) 
	    {
	   Map<String, Object> map = super.getErrorAttributes(requestAttributes, includeStackTrace);
	    map.put("company","alpha");
	    return map;
	 }
}
