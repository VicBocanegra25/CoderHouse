package com.coderhouser.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderhouse.modelos.DetalleDeCompra;

public interface DetalleDeCompraRepositorio extends JpaRepository<DetalleDeCompra, Integer> {

}
