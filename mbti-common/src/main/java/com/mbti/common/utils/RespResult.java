package com.mbti.common.utils;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RespResult extends Object implements Serializable{
	
	//公共变量
	public static final String SUCCESS="0"; //操作成功
	public static final String FAIL="1";// 操作失败
	public static final String EMPTY_RESULT="2";// 查询结果为空
	public static final String ILLEGAL="101";//非法操作
	public static final String NOLOGIN="102";// 未登录
	//私有变量
	private String code;
	//
	private Long total;
	private String message;
	private Object result;

	public RespResult() {
		
	}

	public RespResult(String code) {
		this.code = code;
	}

	public RespResult(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public RespResult(String code, Object result) {
		this.code = code;
		this.result = result;
	}

	public RespResult(String code, String message, Object result) {
		this.code = code;
		this.message = message;
		this.result = result;
	}


	public RespResult(String code, Long total, String message, Object result) {
		this.code = code;
		this.total = total;
		this.message = message;
		this.result = result;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
	
}
