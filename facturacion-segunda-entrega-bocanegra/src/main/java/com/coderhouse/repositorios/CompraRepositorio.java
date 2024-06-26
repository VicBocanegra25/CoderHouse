package com.coderhouse.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderhouse.modelos.Compra;

@Repository
public interface CompraRepositorio extends JpaRepository<Compra, Integer>{

}
