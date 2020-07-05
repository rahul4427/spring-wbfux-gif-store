package com.rk.gifstore.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.rk.gifstore.exception.GiffStoreBadRequestException;
import com.rk.gifstore.exception.GiffStoreError;
import com.rk.gifstore.exception.GiffStoreForbiddenException;

@ControllerAdvice
public class GiffStoreControllerAdvice {
	
	@ExceptionHandler(GiffStoreForbiddenException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ResponseBody
	public GiffStoreError handleForbiddenException(GiffStoreForbiddenException ex) {
		return createResponseErrorMessage(ex.getMessage());
	}
	
	@ExceptionHandler(GiffStoreBadRequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public GiffStoreError handleBadRequestException(GiffStoreBadRequestException ex) {
		return createResponseErrorMessage(ex.getMessage());
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public GiffStoreError handleAllOtherException(Exception ex) {
		return createResponseErrorMessage(ex.getMessage());
	}
	
	private GiffStoreError createResponseErrorMessage(String message) {
		GiffStoreError responseErrorMessage = new GiffStoreError();
		responseErrorMessage.setMessage(message);
		return responseErrorMessage;
	}
}
