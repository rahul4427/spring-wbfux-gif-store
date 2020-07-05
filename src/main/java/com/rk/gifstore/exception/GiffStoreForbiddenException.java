package com.rk.gifstore.exception;

public class GiffStoreForbiddenException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7509817981075336181L;
	private String message;

	public GiffStoreForbiddenException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
