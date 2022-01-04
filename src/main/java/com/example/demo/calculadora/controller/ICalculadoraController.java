package com.example.demo.calculadora.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.http.MediaType;

@RequestMapping(
		value="/operacion", 
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
public interface ICalculadoraController {

	@GetMapping("/sumar/{num1}/{num2}")
	@ApiOperation(value = "Suma dos números")
	@ResponseStatus(value = HttpStatus.OK)
	@ApiResponses(value = { 
			   @ApiResponse(code = 200, message = "OK", response = Double.class),
	           @ApiResponse(code = 400, message = "Bad Request"),
	           @ApiResponse(code = 401, message = "Unauthorized"),
	           @ApiResponse(code = 403, message = "Access denied"),
	           @ApiResponse(code = 500, message = "500 Failure")})
	public ResponseEntity<Double> sumar(@PathVariable(value="num1", required=true) Double num1,  @PathVariable(value="num2", required=true) Double num2);
	
	@GetMapping("/restar/{num1}/{num2}")
	@ApiOperation(value = "Resta dos números")
	@ResponseStatus(value = HttpStatus.OK)
	@ApiResponses(value = { 
			   @ApiResponse(code = 200, message = "OK", response = Double.class),
	           @ApiResponse(code = 400, message = "Bad Request"),
	           @ApiResponse(code = 401, message = "Unauthorized"),
	           @ApiResponse(code = 403, message = "Access denied"),
	           @ApiResponse(code = 500, message = "500 Failure")})
	public ResponseEntity<Double> restar(@PathVariable(value="num1", required=true) Double num1,  @PathVariable(value="num2", required=true) Double num2);
	
	
}
