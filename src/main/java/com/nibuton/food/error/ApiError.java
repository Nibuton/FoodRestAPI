package com.nibuton.food.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiError {
	
	private String message;
	private String exceptionMessage;
	private HttpStatus status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	
	{
		timestamp = LocalDateTime.now();
		message = "Unexpected error";
		
	}
	
	ApiError(HttpStatus status){
		this.status = status;
	}
	
	ApiError(HttpStatus status, Throwable ex){
		this(status);
		this.exceptionMessage = ex.getMessage();
	}
	
	public ApiError(HttpStatus status, Throwable ex, String message) {
		this(status,ex);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
