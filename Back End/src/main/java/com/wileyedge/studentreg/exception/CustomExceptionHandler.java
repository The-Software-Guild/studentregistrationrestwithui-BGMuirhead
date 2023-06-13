package com.wileyedge.studentreg.exception;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest req) 
	{  
		ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(), "An Exception Occured");
		
		return new ResponseEntity(response , HttpStatus.INTERNAL_SERVER_ERROR);
				
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex,WebRequest req)
	{
		ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(), "User not found");
		
		return new ResponseEntity(response , HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

//		ExceptionResponse response = new ExceptionResponse(new Date(),"Validation Failed",ex.getBindingResult().toString());
		ExceptionResponse response = new ExceptionResponse(new Date(),"Validation Failed",ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
		
		
//		List<ObjectError> errors = ex.getBindingResult().getAllErrors();
//		
//		for(ObjectError e: errors)
//		{
//			System.out.println(e.getDefaultMessage());
//		}
		
		return new ResponseEntity(response , HttpStatus.BAD_REQUEST);
	}
	
}
