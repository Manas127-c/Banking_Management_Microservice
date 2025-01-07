package com.banking.accounnt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourseNotFoundException.class)
	public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourseNotFoundException ex){
		String message=ex.getMessage();
		ApiResponse response=new ApiResponse(message,false,HttpStatus.NOT_FOUND);
		return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
	}
}
