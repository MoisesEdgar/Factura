package com.example.demo.Models;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String folio;
    private Double total;
    private Date fechaExpedicion;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    private List<Partida> partidas;

    public void calcularTotal() {
        this.total = partidas.stream()
                .mapToDouble(Partida::getTotalBasePrecioArticulo)
                .sum();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public List<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<Partida> partidas) {
        this.partidas = partidas;
    }
}