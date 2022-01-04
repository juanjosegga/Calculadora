package com.example.demo.calculadora.services;

import org.springframework.web.bind.annotation.PathVariable;

public interface ICalculadoraService {

	public Double sumar(@PathVariable Double num1, @PathVariable Double num2);
	public Double restar(@PathVariable Double num1, @PathVariable Double num2);
}
