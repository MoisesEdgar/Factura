package com.example.Facturas.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long FacturaId;
    private String FacturaFolio;
    private double FacturaTotal;
    private LocalDate FacturaFechaExpedicion;
   // mappedBy = "IdFactura",
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Partida> partidas ;



    public Set<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(Set<Partida> partidas) {
        this.partidas = partidas;
    }

    public Long getFacturaId() {
        return FacturaId;
    }

    public void setFacturaId(Long facturaId) {
        FacturaId = facturaId;
    }

    public String getFacturaFolio() {
        return FacturaFolio;
    }

    public void setFacturaFolio(String facturaFolio) {
        FacturaFolio = facturaFolio;
    }

    public double getFacturaTotal() {

        return FacturaTotal;
    }

    public void setFacturaTotal(double facturaTotal) {
        FacturaTotal = facturaTotal;
    }

    public LocalDate getFacturaFechaExpedicion() {
        return FacturaFechaExpedicion;
    }

    public void setFacturaFechaExpedicion(LocalDate facturaFechaExpedicion) {
        FacturaFechaExpedicion = facturaFechaExpedicion;
    }
}

