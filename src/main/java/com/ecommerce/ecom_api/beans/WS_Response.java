package com.ecommerce.ecom_api.beans;

import java.io.Serializable;

public class WS_Response implements Serializable {
	private static final long serialVersionUID = 1L;
	
	String status;
	Integer statusCode;
	String msg;
	Object object;
	
	public WS_Response() {
		super();
	}
	
	public WS_Response(String status, Integer statusCode, String msg, Object object) {
		super();
		this.status = status;
		this.statusCode = statusCode;
		this.msg = msg;
		this.object = object;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}

	@Override
	public String toString() {
		return "WS_Response [status=" + status + ", statusCode=" + statusCode + ", msg=" + msg + ", object=" + object
				+ "]";
	}

}
