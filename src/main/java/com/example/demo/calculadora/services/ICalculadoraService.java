package com.example.demo.calculadora.services;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.calculadora.dto.CalculadoraResponse;

public interface ICalculadoraService {

	public CalculadoraResponse sumar(@PathVariable Double num1, @PathVariable Double num2);
	public CalculadoraResponse restar(@PathVariable Double num1, @PathVariable Double num2);
}
