package com.example.demo.calculadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.calculadora.services.ICalculadoraService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "CalculadoraControllerImpl", tags = { "Calculadora" })	
public class CalculadoraControllerImpl implements ICalculadoraController {

	@Autowired
	ICalculadoraService iCalculadoraService;
	
	@Override
	public ResponseEntity<Double> sumar(Double num1, Double num2) {
		return new ResponseEntity<Double>(iCalculadoraService.sumar(num1, num2) , HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Double> restar(Double num1, Double num2) {
		return new ResponseEntity<Double>(iCalculadoraService.restar(num1, num2) , HttpStatus.OK);
	}

}
