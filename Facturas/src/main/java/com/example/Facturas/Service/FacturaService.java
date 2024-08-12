package com.example.Facturas.Service;

import com.example.Facturas.Model.Factura;
import com.example.Facturas.Model.Partida;

import java.util.List;

public interface FacturaService {

    //POST
    Factura saveFactura(Factura factura, Partida partida);

    Partida savePartida(Partida partida);

    //GET
    List<Factura> getFacturaList();

    List<Partida> getPartidaList();

    Factura getFacturaById(Long FacturaId);

    //PUT
    Factura updateFactura(Factura factura, Long FacturaId);

    //DEL
    void deleteFacturaById(Long FacturaId);

}
