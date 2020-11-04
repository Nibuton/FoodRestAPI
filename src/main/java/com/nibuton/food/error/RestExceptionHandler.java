package com.nibuton.food.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	public RestExceptionHandler() {
		// TODO Auto-generated constructor stub
	}
	
	@ExceptionHandler
	public ResponseEntity<ApiError> handleEntityNotFoundException(EntityNotFoundException exc){
		ApiError err = new ApiError(HttpStatus.NOT_FOUND,exc);
		return buildResponseEntity(err);
	}
	
	private ResponseEntity<ApiError> buildResponseEntity(ApiError err){
		return new ResponseEntity<>(err, err.getStatus());
	}

}
