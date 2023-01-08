package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(InvalidInput.class)
	public ResponseEntity<String> invalidInputHandler(InvalidInput ii){
	String message=	ii.getMessage();
	return new ResponseEntity(message,HttpStatus.NOT_FOUND);
	}
	
	
}
