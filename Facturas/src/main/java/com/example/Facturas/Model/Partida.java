package com.example.Facturas.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Partida {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PartidaId;
    private String PartidaNombreArticulo;
    private int PartidaCantidadAdquirida;
    private double PartidaPrecioUnitarioArticulo;
    private double PartidaTotalBasePrecioArticulo;

    @ManyToOne
    @JoinColumn(name = "FacturaId")
    private  Factura IdFactura ;


    public Factura getIdFactura() {
        return IdFactura;
    }

    public void setIdFactura(Factura idFactura) {
        IdFactura = idFactura;
    }

    double total;
    private void calcularTotalBase() {
        this.PartidaTotalBasePrecioArticulo = this.PartidaPrecioUnitarioArticulo * this.PartidaCantidadAdquirida;
        this.total = this.total + this.PartidaTotalBasePrecioArticulo;
    }

    public double getTotal(){
        return total;
    }

    public Long getPartidaId() {
        return PartidaId;
    }

    public void setPartidaId(Long partidaId) {
        PartidaId = partidaId;
    }

    public String getPartidaNombreArticulo() {
        return PartidaNombreArticulo;
    }

    public void setPartidaNombreArticulo(String partidaNombreArticulo) {
        PartidaNombreArticulo = partidaNombreArticulo;
    }

    public int getPartidaCantidadAdquirida() {
        return PartidaCantidadAdquirida;
    }

    public void setPartidaCantidadAdquirida(int partidaCantidadAdquirida) {
        if (partidaCantidadAdquirida >= 0) {
            this.PartidaCantidadAdquirida = partidaCantidadAdquirida;
            PartidaCantidadAdquirida = partidaCantidadAdquirida;
        }
    }

    public double getPartidaPrecioUnitarioArticulo() {
        return PartidaPrecioUnitarioArticulo;
    }

    public void setPartidaPrecioUnitarioArticulo(double partidaPrecioUnitarioArticulo) {
        if( partidaPrecioUnitarioArticulo >= 0) {
            this.PartidaPrecioUnitarioArticulo = partidaPrecioUnitarioArticulo;
            PartidaPrecioUnitarioArticulo = partidaPrecioUnitarioArticulo;
        }
    }

    public double getPartidaTotalBasePrecioArticulo() {
        calcularTotalBase();
        return PartidaTotalBasePrecioArticulo;
    }

    public void setPartidaTotalBasePrecioArticulo(double partidaTotalBasePrecioArticulo) {
        PartidaTotalBasePrecioArticulo = partidaTotalBasePrecioArticulo;
    }

}
