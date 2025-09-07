package com.jsp.SpringBootJPA.Exception;

import java.lang.reflect.Array;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(AccountisNotfound.class)
	public ResponseEntity<ErrorResponse> handleaccountisnotfound(AccountisNotfound exception){
		ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), exception.getMessage(), "accountNo is not found");
		return new ResponseEntity(errorResponse,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(ArrayIndexOutOfBoundsException.class)
	public ResponseEntity<String> handleaccountisnotfound(ArrayIndexOutOfBoundsException exception){
		ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), exception.getMessage(), "accountNo is not found");
		return new ResponseEntity(errorResponse,HttpStatus.NOT_FOUND);
	}
}
