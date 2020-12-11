package com.example.demo.response;

import lombok.Getter;

/**
 * 
 * Description: ResultCodeEnum
 * 
 */
@Getter
public enum ResultCodeEnum {

	AUTH_FAIL(false, 10000, "鉴权失败"), //
	AUTH_TOKEN_EXPIRE(false, 10001, "refreshToken过期"), //
	AUTH_REFRESH_TOKEN_EXPIRE(false, 10002, "refreshToken过期"), //
	SUCCESS(true, 20000, "成功"), //
	UNKNOWN_REASON(false, 20001, "未知错误"), //
	PARAM_ERROR(false, 21003, "参数不正确");

	private Boolean success;
	private Integer code;
	private String message;

	private ResultCodeEnum(Boolean success, Integer code, String message) {
		this.success = success;
		this.code = code;
		this.message = message;
	}
}