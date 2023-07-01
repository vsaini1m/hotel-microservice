package com.vsaini1m.hotel.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vsaini1m.dto.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException  exception){
		
		ApiResponse apiResponse = ApiResponse.builder().message(exception.getMessage())
		.success(true)
		.status(HttpStatus.NO_CONTENT).build();
		
		return new ResponseEntity<>(apiResponse, HttpStatus.NO_CONTENT);
	}
}