package com.example.demo.Service;

import com.example.demo.Models.Factura;
import com.example.demo.Models.Partida;
import com.example.demo.Repository.FacturaRepository;
import com.example.demo.Repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;
    @Autowired
    private PartidaRepository partidaRepository;

    public Factura crearFactura(Factura factura) {
        factura.getPartidas().forEach(Partida::calcularTotalBasePrecioArticulo);
        factura.calcularTotal();
        return facturaRepository.save(factura);
    }

    public Factura obtenerFactura(Long id) {
        return facturaRepository.findById(id).orElseThrow(() -> new RuntimeException("Factura no encontrada"));
    }

    public List<Factura> obtenerTodasFacturas() {
        return facturaRepository.findAll();
    }

    public Factura actualizarFactura(Long id, Factura facturaDetalles) {
        Factura factura = obtenerFactura(id);
        factura.setFolio(facturaDetalles.getFolio());
        factura.setFechaExpedicion(facturaDetalles.getFechaExpedicion());
        factura.getPartidas().clear();
        factura.getPartidas().addAll(facturaDetalles.getPartidas());
        factura.getPartidas().forEach(Partida::calcularTotalBasePrecioArticulo);
        factura.calcularTotal();
        return facturaRepository.save(factura);
    }

    public void eliminarFactura(Long id) {
        facturaRepository.deleteById(id);
    }
}
