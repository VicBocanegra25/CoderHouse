package com.coderhouse.repositorios;

import com.coderhouse.modelos.Comprobante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComprobanteRepositorio extends JpaRepository<Comprobante, Integer> {

}
