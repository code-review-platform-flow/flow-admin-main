package com.flow.admin.main.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(CustomNotFoundException.class)
	public ResponseEntity<String> handleOrderNotFoundException(CustomNotFoundException ex) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
