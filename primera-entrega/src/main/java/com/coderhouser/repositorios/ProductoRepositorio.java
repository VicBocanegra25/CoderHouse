package com.coderhouser.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderhouse.entidades.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer>{

}
