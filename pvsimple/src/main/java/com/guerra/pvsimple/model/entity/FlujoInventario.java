package com.guerra.pvsimple.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "flujo_inventario")
@Getter
@Setter
public class FlujoInventario implements Serializable {

    public static final int ESTADO_ACTIVO = 1;
    public static final int ESTADO_ANULADO = 0;
    public static final int AGREGAR_INVENTARIO = 1;
    public static final int SACAR_INVENTARIO = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "concepto", nullable = false, length = 100)
    private String concepto;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "tipo", nullable = false)
    private Integer tipo;

    @Column(name = "estado", nullable = false)
    private Integer estado;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto idProducto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario idUsuario;

}
