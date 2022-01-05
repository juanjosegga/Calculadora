package com.example.demo.calculadora.excepctions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
  
	@ExceptionHandler(CalculadoraException.class)
	public ResponseEntity<ErrorMessage> globalExceptionHandler(Exception ex) {	
		List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        
		ErrorMessage message = new ErrorMessage(
	        HttpStatus.INTERNAL_SERVER_ERROR.value(),
	        ex.getMessage(),
	        details);
    
		return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}