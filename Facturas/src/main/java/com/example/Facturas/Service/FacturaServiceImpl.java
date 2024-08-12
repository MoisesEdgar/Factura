package com.example.Facturas.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.example.Facturas.Model.Factura;
import com.example.Facturas.Model.Partida;
import com.example.Facturas.Repository.FacturaRepository;
import com.example.Facturas.Repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private PartidaRepository partidaRepository;

    //POST
    @Override
    public Factura saveFactura(Factura factura, Partida partida){
        factura.setFacturaTotal(partida.getTotal());
        return facturaRepository.save(factura);

    }


    @Override
    public Partida savePartida(Partida partida){
        return partidaRepository.save(partida);
    }

    //GET
    @Override
    public List<Factura> getFacturaList() {
        return (List<Factura>)facturaRepository.findAll();
    }

    @Override
    public List<Partida> getPartidaList() {
        return (List<Partida>)partidaRepository.findAll();
    }

    @Override
    public Factura getFacturaById(Long FacturaId) {
        Optional<Factura> factura = facturaRepository.findById(FacturaId);
        return factura.orElse(null);
    }

    //PUT
    @Override
    public Factura updateFactura(Factura factura, Long FacturaId) {
        Factura depDB = facturaRepository.findById(FacturaId).get();

        if (depDB == null){
            return null;
        }

        if (Objects.nonNull(
                factura.getFacturaFolio())){
            depDB.setFacturaFolio(
                    factura.getFacturaFolio());
        }

        if (Objects.nonNull(
                factura.getFacturaFechaExpedicion())){
            depDB.setFacturaFechaExpedicion(
                    factura.getFacturaFechaExpedicion());
        }
        return facturaRepository.save(depDB);
    }

    //DEL
    @Override
    public void deleteFacturaById(Long FacturaId) {
        facturaRepository.deleteById(FacturaId);
    }
}


