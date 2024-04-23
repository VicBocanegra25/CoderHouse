package com.coderhouse.repositorios;

// Los repositorios servirán como interfaces para acceder a los datos
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderhouse.modelos.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {
	}
