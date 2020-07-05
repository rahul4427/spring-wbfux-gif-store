package com.rk.gifstore.exception;

public class GiffStoreNoDataFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3444651423782916185L;
	private String message;

	public GiffStoreNoDataFoundException(String message) {
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
