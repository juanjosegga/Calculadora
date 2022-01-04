package com.example.demo.calculadora.services;

import java.text.MessageFormat;

import org.springframework.stereotype.Service;

import io.corp.calculator.TracerImpl;

@Service
public class CalculadoraServiceImpl implements ICalculadoraService{

	TracerImpl tracer = new TracerImpl();
	
	@Override
	public Double sumar(Double num1, Double num2) {	
		tracer.trace(MessageFormat.format("Sumar {0} +  {1} = {2}", num1, num2 , num1 + num2));
		return num1 + num2;
	}

	@Override
	public Double restar(Double num1, Double num2) {
		tracer.trace(MessageFormat.format("Restar {0} -  {1} = {2}", num1, num2 , num1 - num2));
		return num1 - num2;
	}

}
