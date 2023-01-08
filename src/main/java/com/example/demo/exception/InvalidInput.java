package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidInput extends RuntimeException {
	
	/**      
	 *   Shivraj
	 */   
	private static final long serialVersionUID = 1L;
	
	String message;
	
	public InvalidInput(String message1) {
		super(message1);
		this.message=message1;
	}
	

}
