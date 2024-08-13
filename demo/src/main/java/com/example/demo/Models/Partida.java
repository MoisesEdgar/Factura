package com.example.demo.Models;

import jakarta.persistence.*;

@Entity
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreArticulo;
    private Integer cantidadAdquirida;
    private Double precioUnitarioArticulo;
    private Double totalBasePrecioArticulo;

    @ManyToOne
    @JoinColumn(name = "factura_id")
    private Factura factura;

    public void calcularTotalBasePrecioArticulo() {
        this.totalBasePrecioArticulo = this.cantidadAdquirida * this.precioUnitarioArticulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public Integer getCantidadAdquirida() {
        return cantidadAdquirida;
    }

    public void setCantidadAdquirida(Integer cantidadAdquirida) {
        this.cantidadAdquirida = cantidadAdquirida;
    }

    public Double getPrecioUnitarioArticulo() {
        return precioUnitarioArticulo;
    }

    public void setPrecioUnitarioArticulo(Double precioUnitarioArticulo) {
        this.precioUnitarioArticulo = precioUnitarioArticulo;
    }

    public Double getTotalBasePrecioArticulo() {
        return totalBasePrecioArticulo;
    }

    public void setTotalBasePrecioArticulo(Double totalBasePrecioArticulo) {
        this.totalBasePrecioArticulo = totalBasePrecioArticulo;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
}
