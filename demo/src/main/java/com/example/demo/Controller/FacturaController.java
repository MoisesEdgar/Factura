package com.example.demo.Controller;

import com.example.demo.Models.Factura;
import com.example.demo.Service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @PostMapping("/Factura")
    public Factura crearFactura(@RequestBody Factura factura) {
        return facturaService.crearFactura(factura);
    }

    @GetMapping("/Factura/{id}")
    public Factura obtenerFactura(@PathVariable Long id) {
        return facturaService.obtenerFactura(id);
    }

    @GetMapping("/Facturas")
    public List<Factura> obtenerTodasFacturas() {
        return facturaService.obtenerTodasFacturas();
    }

    @PutMapping("/Factura/{id}")
    public Factura actualizarFactura(@PathVariable Long id, @RequestBody Factura facturaDetalles) {
        return facturaService.actualizarFactura(id, facturaDetalles);
    }

    @DeleteMapping("/Factura/{id}")
    public void eliminarFactura(@PathVariable Long id) {
        facturaService.eliminarFactura(id);
    }
}
