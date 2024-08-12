package com.example.Facturas.Repository;

import com.example.Facturas.Model.Factura;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends CrudRepository<Factura, Long> {

}
