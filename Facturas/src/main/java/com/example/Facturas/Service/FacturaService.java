package com.example.Facturas.Service;

import com.example.Facturas.Model.Factura;
import com.example.Facturas.Model.Partida;
import com.example.Facturas.Repository.FacturaRepository;
import com.example.Facturas.Repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class  FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;
    @Autowired
    private PartidaRepository partidaRepository;

    //********************************************************************
    //POST
    public Factura saveFactura(Factura factura){
        factura.getPartidas().forEach(Partida::calcularTotalBasePrecioArticulo);
        factura.calcularTotal();
        return facturaRepository.save(factura);
    }

    //GET
    public List<Factura> getFacturaList(){
        return facturaRepository.findAll();
    }

    public Factura getFacturaById(Long FacturaId){
        Optional<Factura> factura = facturaRepository.findById(FacturaId);
        return factura.orElse(null);
    }

    //************************************************************************
    //PUT
    public Factura updateFactura(Factura facturaDetalles, Long FacturaId){
        Factura factura = getFacturaById(FacturaId);
        factura.setFacturaFolio(facturaDetalles.getFacturaFolio());
        factura.setFacturaFechaExpedicion(facturaDetalles.getFacturaFechaExpedicion());
        factura.getPartidas().clear();
        factura.getPartidas().addAll(facturaDetalles.getPartidas());
        factura.calcularTotal();
        return facturaRepository.save(factura);
    }

    //DEL
    public void deleteFacturaById(long FacturaId){
        facturaRepository.deleteById(FacturaId);
    }



}
