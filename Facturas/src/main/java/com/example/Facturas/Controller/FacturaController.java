package com.example.Facturas.Controller;

import com.example.Facturas.Model.Factura;
import com.example.Facturas.Model.Partida;
import com.example.Facturas.Service.FacturaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FacturaController {

    @Autowired private FacturaService facturaService;


    @PostMapping("/Factura")
    public Factura saveFactura(@Valid @RequestBody Factura factura, Partida partida){
        return facturaService.saveFactura(factura, partida);
    }

    @PostMapping("/Partida")
    public Partida savePartida(@Valid @RequestBody Partida partida){
        return facturaService.savePartida(partida);
    }

    @GetMapping("/Facturas")
    public List<Factura> getFacturaList(){
        return facturaService.getFacturaList();
    }

    @GetMapping("/Partidas")
    public List<Partida> getPartidaList(){
        return facturaService.getPartidaList();
    }

    @GetMapping("/Factura/{id}")
    public Factura getFacturaById(@PathVariable("id") Long FacturaId)
    {
        Factura factura = facturaService.getFacturaById(FacturaId);
        return new ResponseEntity<>(factura, HttpStatus.OK).getBody();
    }

    @PutMapping("/Factura/{id}")
    public Factura updateFactura(@RequestBody Factura factura, @PathVariable("id") Long FacturaId){
        return facturaService.updateFactura(factura ,FacturaId);
    }

    @DeleteMapping("/Factura/{id}")
    public String deleteFacturaById(@PathVariable("id") Long FacturaId)
    {
        facturaService.deleteFacturaById(FacturaId);
        return "Deleted Successfully";
    }

}
