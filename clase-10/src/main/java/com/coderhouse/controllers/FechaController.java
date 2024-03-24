package com.coderhouse.controllers;

import java.time.LocalDateTime;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fecha")
public class FechaController {
	
	// El contador de invocaciones va fuera del método
	private int invocacionesCount = 0;
	
	@GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public String obtenerFechaYHora() {
		
		invocacionesCount++;
		LocalDateTime fechaACtual = LocalDateTime.now();
		
		String mensaje = "Fecha y Hora Actuales: " + fechaACtual.toString() + 
		"\nNúmero de veces que fue invocado: " +  invocacionesCount;
		return mensaje;
	}
	
	
}
