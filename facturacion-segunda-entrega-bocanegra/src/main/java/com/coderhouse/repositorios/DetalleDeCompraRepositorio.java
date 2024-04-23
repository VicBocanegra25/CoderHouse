package com.coderhouse.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderhouse.modelos.DetalleDeCompra;

@Repository
public interface DetalleDeCompraRepositorio extends JpaRepository<DetalleDeCompra, Integer> {

}
