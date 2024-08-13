package com.example.Facturas.Service;

import com.example.Facturas.Model.Factura;
import com.example.Facturas.Model.Partida;
import com.example.Facturas.Repository.FacturaRepository;
import com.example.Facturas.Repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class  FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;
    @Autowired
    private PartidaRepository partidaRepository;

    //POST
    public Factura saveFactura(Factura factura){
        factura.calcularTotalFactura();
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

    //PUT
    public Factura updateFactura(Factura factura, Long FacturaId) {
        Factura depDB = facturaRepository.findById(FacturaId).get();

        if (Objects.nonNull(
                factura.getFacturaFolio()) && !"".equalsIgnoreCase(factura.getFacturaFolio())){
            depDB.setFacturaFolio(factura.getFacturaFolio());
        }

        if (Objects.nonNull(
                factura.getFacturaFechaExpedicion())){
            depDB.setFacturaFechaExpedicion(
                    factura.getFacturaFechaExpedicion());
        }

        depDB.getPartidas().clear();
        depDB.getPartidas().addAll(factura.getPartidas());
        depDB.calcularTotalFactura();

        return facturaRepository.save(depDB);
    }

    //DEL
    public void deleteFacturaById(long FacturaId){
        facturaRepository.deleteById(FacturaId);
    }



}
