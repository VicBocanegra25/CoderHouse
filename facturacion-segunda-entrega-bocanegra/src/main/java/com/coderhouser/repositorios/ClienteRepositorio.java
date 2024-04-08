package com.coderhouser.repositorios;

// Los repositorios servirán como interfaces para acceder a los datos
import org.springframework.data.jpa.repository.JpaRepository;

import com.coderhouse.modelos.Cliente;

	public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {
	}
