package com.example.demo.calculadora.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CalculadoraResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("resultado")
	private Double resultado;

}
