package com.example.demo.calculadora.excepctions;

import java.util.List;

import lombok.Data;

@Data
public class ErrorMessage {

	private int statusCode;
    private String message;
    private List<String> details;

  public ErrorMessage(int statusCode, String message, List<String> details) {
    this.statusCode = statusCode;
    this.message = message;
    this.details = details;
  }

}
