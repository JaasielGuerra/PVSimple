package com.guerra.pvsimple.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "detalle_venta")
@Getter
@Setter
public class DetalleVenta implements Serializable {

    public static final int ESTADO_REALIZADA = 1;
    public static final int ESTADO_ANULADA = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "precio_costo", nullable = false)
    private Double precioCosto;

    @Column(name = "precio_unitario", nullable = false)
    private Double precioUnitario;

    @Column(name = "sub_total", nullable = false)
    private Double subTotal;

    @Column(name = "total_ganancia", nullable = false)
    private Double totalGanancia;

    @Column(name = "estado", nullable = false)
    private Integer estado;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_venta", nullable = false)
    private Venta idVenta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto idProducto;

}
