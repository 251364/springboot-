package com.example.demo.response;

import java.util.HashMap;


import lombok.Data;

/**
 * 
 * Description: 全局统一返回结果


 */
@Data

public class R {

	private Boolean success;//是否成功

	private Integer code;//返回码

	private String message;//返回消息

	private Object data = new HashMap<>();//返回数据

	private R() {
	}

	public static R ok() {
		R r = new R();
		r.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
		r.setCode(ResultCodeEnum.SUCCESS.getCode());
		r.setMessage(ResultCodeEnum.SUCCESS.getMessage());
		return r;
	}

	public static R error() {
		R r = new R();
		r.setSuccess(ResultCodeEnum.UNKNOWN_REASON.getSuccess());
		r.setCode(ResultCodeEnum.UNKNOWN_REASON.getCode());
		r.setMessage(ResultCodeEnum.UNKNOWN_REASON.getMessage());
		return r;
	}

	public static R setResult(ResultCodeEnum resultCodeEnum) {
		R r = new R();
		r.setSuccess(resultCodeEnum.getSuccess());
		r.setCode(resultCodeEnum.getCode());
		r.setMessage(resultCodeEnum.getMessage());
		return r;
	}

	public R success(Boolean success) {
		this.setSuccess(success);
		return this;
	}

	public R message(String message) {
		this.setMessage(message);
		return this;
	}

	public R code(Integer code) {
		this.setCode(code);
		return this;
	}

	public R data(Object data) {
		this.setData(data);
		return this;
	}

}
