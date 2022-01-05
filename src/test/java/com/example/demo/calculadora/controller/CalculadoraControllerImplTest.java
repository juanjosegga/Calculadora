package com.example.demo.calculadora.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.example.demo.calculadora.CalculadoraApplication;
import com.example.demo.calculadora.dto.CalculadoraResponse;


@SpringBootTest(classes = CalculadoraApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Test de integración del controlador /CalculadoraControllerImpl")
class CalculadoraControllerImplTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	private static final String URL_SUMAR_SERVICEID =   "/operacion/sumar/{num1}/{num2}";
	private static final String URL_RESTAR_SERVICEID =  "/operacion/restar/{num1}/{num2}";
	
	@Test
	@DisplayName("Comprobación de llamada erronea al endpoint /operacion/sumar [HTTP 404]")
	void given_num1_num2_sumar_then_return_not_found() throws Exception {
			
		Map<String, String> map = new HashMap<>();
		map.put("num1", "1");
		map.put("num2", "");
		
		ResponseEntity<CalculadoraResponse> response = restTemplate.getForEntity(URL_SUMAR_SERVICEID, CalculadoraResponse.class, map);
		
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	@Test
	@DisplayName("Comprobación de llamada erronea al endpoint /operacion/sumar [HTTP 415]")
	void given_num1_num2_sumar_then_return_unsupported_media_type() throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("num1", "1,");
		map.put("num2", "1");
		
		ResponseEntity<CalculadoraResponse> response = restTemplate.getForEntity(URL_SUMAR_SERVICEID, CalculadoraResponse.class, map);
		
		assertEquals(HttpStatus.UNSUPPORTED_MEDIA_TYPE, response.getStatusCode());
	}
	
	@Test
	@DisplayName("Comprobación de llamada correcta al endpoint /operacion/sumar [HTTP 200]")
	void given_num1_num2_sumar_then_return_ok() throws Exception {
	
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<String>(headers);
				
		Map<String, String> map = new HashMap<>();
		map.put("num1", "2");
		map.put("num2", "2");
		
		
		// make an HTTP GET request with headers
		ResponseEntity<CalculadoraResponse> response = restTemplate.exchange(
				URL_SUMAR_SERVICEID,
		        HttpMethod.GET,
		        entity,
		        CalculadoraResponse.class,
		        map
		);
			
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	
	@Test
	@DisplayName("Comprobación de llamada erronea al endpoint /operacion/restar [HTTP 404]")
	void given_num1_num2_restar_then_return_not_found() throws Exception {
			
		Map<String, String> map = new HashMap<>();
		map.put("num1", "1");
		map.put("num2", "");
		
		ResponseEntity<CalculadoraResponse> response = restTemplate.getForEntity(URL_RESTAR_SERVICEID, CalculadoraResponse.class, map);
		
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	@Test
	@DisplayName("Comprobación de llamada erronea al endpoint /operacion/restar [HTTP 415]")
	void given_num1_num2_restarr_then_return_unsupported_media_type() throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("num1", "1,");
		map.put("num2", "1");
		
		ResponseEntity<CalculadoraResponse> response = restTemplate.getForEntity(URL_RESTAR_SERVICEID, CalculadoraResponse.class, map);
		
		assertEquals(HttpStatus.UNSUPPORTED_MEDIA_TYPE, response.getStatusCode());
	}
	
	@Test
	@DisplayName("Comprobación de llamada correcta al endpoint /operacion/restar [HTTP 200]")
	void given_num1_num2_restar_then_return_ok() throws Exception {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<String>(headers);
				
		Map<String, String> map = new HashMap<>();
		map.put("num1", "2");
		map.put("num2", "2");
		
		
		// make an HTTP GET request with headers
		ResponseEntity<CalculadoraResponse> response = restTemplate.exchange(
				URL_RESTAR_SERVICEID,
		        HttpMethod.GET,
		        entity,
		        CalculadoraResponse.class,
		        map
		);
			
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	

}
