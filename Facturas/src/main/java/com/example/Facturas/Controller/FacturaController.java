package com.example.Facturas.Controller;

import com.example.Facturas.Model.Factura;
import com.example.Facturas.Service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @PostMapping("/Factura")
    public Factura saveFactura(@RequestBody Factura factura){
        return facturaService.saveFactura(factura);
    }

    @GetMapping("/Facturas")
    public List<Factura> getFacturaList(){
        return facturaService.getFacturaList();
    }

    @GetMapping("/Factura/{id}")
    public Factura getFacturaById(@PathVariable("id") Long FacturaId) {
        return facturaService.getFacturaById(FacturaId);
    }


    @PutMapping("/Factura/{id}")
    public Factura updateFactura(@RequestBody Factura factura, @PathVariable("id") Long FacturaId){
        return facturaService.updateFactura(factura ,FacturaId);
    }

    @DeleteMapping("/Factura/{id}")
    public String deleteFacturaById(@PathVariable("id") Long FacturaId){
        facturaService.deleteFacturaById(FacturaId);
        return "Deleted Successfully";
    }

}
