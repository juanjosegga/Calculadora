package com.example.demo.calculadora.services;

import java.text.MessageFormat;

import org.springframework.stereotype.Service;

import com.example.demo.calculadora.excepctions.CalculadoraException;

import io.corp.calculator.TracerImpl;

@Service
public class CalculadoraServiceImpl implements ICalculadoraService{

	TracerImpl tracer = new TracerImpl();
	
	@Override
	public Double sumar(Double num1, Double num2) {	
		Double resultado = 0D;
		tracer.trace(MessageFormat.format("Sumar {0} +  {1} = {2}", num1, num2 , num1 + num2));
		try {
			String valor = String.valueOf(num1);
			num1 = Double.valueOf(valor.replace(".", ","));
			resultado = num1+ num2;
		} catch (Exception e) {
			throw new CalculadoraException((MessageFormat.format("Se ha producido un error al sumar {0} +  {1} ", num1, num2)));
		}
		
		return resultado;
	}

	@Override
	public Double restar(Double num1, Double num2) {
		Double resultado = 0D;
		tracer.trace(MessageFormat.format("Restar {0} -  {1} = {2}", num1, num2 , num1 - num2));
		try {
			resultado = num1 - num2;
		} catch (Exception e) {
			throw new CalculadoraException((MessageFormat.format("Se ha producido un error al sumar {0} +  {1} ", num1, num2)));
		}
		
		return resultado;
	}

}
