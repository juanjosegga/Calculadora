package com.example.demo.calculadora.services;

import java.text.MessageFormat;

import org.springframework.stereotype.Service;

import com.example.demo.calculadora.dto.CalculadoraResponse;
import com.example.demo.calculadora.excepctions.CalculadoraException;

import io.corp.calculator.TracerImpl;

@Service
public class CalculadoraServiceImpl implements ICalculadoraService{

	TracerImpl tracer = new TracerImpl();
	
	@Override
	public CalculadoraResponse sumar(Double num1, Double num2) {	
		CalculadoraResponse calculadoraResponse = new CalculadoraResponse();
		tracer.trace(MessageFormat.format("Sumar {0} +  {1} = {2}", num1, num2 , num1 + num2));
		try {
			calculadoraResponse.setResultado(num1+ num2);
		} catch (Exception e) {
			throw new CalculadoraException((MessageFormat.format("Se ha producido un error al sumar {0} +  {1} ", num1, num2)));
		}
		
		return calculadoraResponse;
	}

	@Override
	public CalculadoraResponse restar(Double num1, Double num2) {
		CalculadoraResponse calculadoraResponse = new CalculadoraResponse();
		tracer.trace(MessageFormat.format("Restar {0} -  {1} = {2}", num1, num2 , num1 - num2));
		try {
			calculadoraResponse.setResultado(num1 - num2);
		} catch (Exception e) {
			throw new CalculadoraException((MessageFormat.format("Se ha producido un error al restar {0} +  {1} ", num1, num2)));
		}
		
		return calculadoraResponse;
	}

}
