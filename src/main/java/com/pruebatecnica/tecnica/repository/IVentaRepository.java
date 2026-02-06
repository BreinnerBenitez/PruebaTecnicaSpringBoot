package com.pruebatecnica.tecnica.repository;

import com.pruebatecnica.tecnica.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta,Long> {
}
