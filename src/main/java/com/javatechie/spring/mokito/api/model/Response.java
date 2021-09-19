package com.javatechie.spring.mokito.api.model;

public class Response {
	
	private String message; 
	private boolean status;
	
	public Response() {
		// TODO Auto-generated constructor stub
	}
	public Response(String message, boolean status) {
		this.setMessage(message);
		this.setStatus(status);
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	public Boolean getStatus() {
		return status;
	}

}
