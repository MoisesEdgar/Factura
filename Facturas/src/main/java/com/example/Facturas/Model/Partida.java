package com.example.Facturas.Model;

import jakarta.persistence.*;


@Entity
public class Partida {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long PartidaId;

   private String PartidaNombreArticulo;
   private Integer PartidaCantidadAdquirida;
   private Double PartidaPrecioUnitarioArticulo;
   private Double PartidaTotalBasePrecioArticulo;

    @ManyToOne
    @JoinColumn(name = "factura_id")
    private  Factura factura ;

    public void calcularTotalBasePrecioArticulo() {
        this.PartidaTotalBasePrecioArticulo = this.PartidaCantidadAdquirida * this.PartidaPrecioUnitarioArticulo;
    }

    public Long getPartidaId() {
        return PartidaId;
    }

    public void setPartidaId(Long partidaId) {
        this.PartidaId = partidaId;
    }

    public String getPartidaNombreArticulo() {
        return PartidaNombreArticulo;
    }

    public void setPartidaNombreArticulo(String partidaNombreArticulo) {
        this.PartidaNombreArticulo = partidaNombreArticulo;
    }

    public Integer getPartidaCantidadAdquirida() {
        return PartidaCantidadAdquirida;
    }

    public void setPartidaCantidadAdquirida(Integer partidaCantidadAdquirida) {
        this.PartidaCantidadAdquirida = partidaCantidadAdquirida;
    }

    public Double getPartidaPrecioUnitarioArticulo() {
        return PartidaPrecioUnitarioArticulo;
    }

    public void setPartidaPrecioUnitarioArticulo(Double partidaPrecioUnitarioArticulo) {
        this.PartidaPrecioUnitarioArticulo = partidaPrecioUnitarioArticulo;
    }

    public Double getPartidaTotalBasePrecioArticulo() {
        return PartidaTotalBasePrecioArticulo;
    }

    public void setPartidaTotalBasePrecioArticulo(Double partidaTotalBasePrecioArticulo) {
        this.PartidaTotalBasePrecioArticulo = partidaTotalBasePrecioArticulo;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
}
