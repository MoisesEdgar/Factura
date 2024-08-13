package com.example.Facturas.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


@Entity

public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long FacturaId;

    private String FacturaFolio;
    private Double FacturaTotal;
    private LocalDate FacturaFechaExpedicion;
    //"factura": null,
    @OneToMany(cascade = CascadeType.ALL)
    private List<Partida> partidas ;

    //****************************************************************************
    public void calcularTotalFactura() {
        this.FacturaTotal = partidas.stream().mapToDouble(Partida::getPartidaTotalBasePrecioArticulo).sum();
    }

    public Long getFacturaId() {
        return FacturaId;
    }

    public void setFacturaId(Long facturaId) {
        this.FacturaId = facturaId;
    }

    public String getFacturaFolio() {
        return FacturaFolio;
    }

    public void setFacturaFolio(String facturaFolio) {

        this.FacturaFolio = facturaFolio;
    }

    public Double getFacturaTotal() {
        return FacturaTotal;
    }

    public void setFacturaTotal(Double facturaTotal) {
        this.FacturaTotal = facturaTotal;
    }

    public LocalDate getFacturaFechaExpedicion() {
        return FacturaFechaExpedicion;
    }

    public void setFacturaFechaExpedicion(LocalDate facturaFechaExpedicion) {
        this.FacturaFechaExpedicion = facturaFechaExpedicion;
    }

    public List<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<Partida> partidas) {
        this.partidas = partidas;
    }
}

