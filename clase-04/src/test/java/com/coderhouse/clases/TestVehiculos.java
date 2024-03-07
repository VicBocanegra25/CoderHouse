package com.coderhouse.clases;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.coderhouse.clases.Vehiculos;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

// Esta clase sirve para probar la clase Vehiculos
public class TestVehiculos {
	
	// Se utiliza para capturar el "Output stream" durante la ejecución
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	// Guarda el resultado de System.out para después de realizar el test
	private final PrintStream originalOut = System.out; 
	
	 @BeforeEach
	    public void setUpStreams() {
	        // Esta función redirige el mensaje que normalmente se imprimiría en la consola a la variable outContent
	        System.setOut(new PrintStream(outContent));
	    }

	    @AfterEach
	    public void restoreStreams() {
	        // Esta función permite regresar el mensaje original a la consola
	        System.setOut(originalOut);
	    }

	    @Test
	    public void testEncenderYaEncendido() {
	        // Instanciamos la clase vehículo
	        Vehiculos vehiculo = new Vehiculos();
	        vehiculo.encender(); // Se llama por primera vez el método, esperamos un mensaje de confirmación
	        vehiculo.encender(); // Se llama por segunda vez el método, esperamos un mensaje diferente

	        String expectedOutput = "El auto ya se encuentra encendido.";
	        // Utilizamos assert para verificar que efectivamente recibimos este segundo mensaje
	        assertTrue(outContent.toString().trim().contains(expectedOutput));

	    }
    }

