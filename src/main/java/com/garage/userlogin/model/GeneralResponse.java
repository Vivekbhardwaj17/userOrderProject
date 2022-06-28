package com.garage.userlogin.model;

import lombok.NoArgsConstructor;


@NoArgsConstructor
public class GeneralResponse {

	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
	private boolean isValid;
	private int statusCode;
	private String message;
	private Object body;
}
