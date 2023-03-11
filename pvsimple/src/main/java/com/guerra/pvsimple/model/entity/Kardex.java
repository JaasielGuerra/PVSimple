package com.guerra.pvsimple.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "kardex")
@Getter
@Setter
public class Kardex implements Serializable {

    public static final int ESTADO_ACTIVO = 1;
    public static final int ESTADO_ANULADO = 0;
    public static final int TIPO_ENTRADA = 1;
    public static final int TIPO_SALIDA = 2;
    public static final int TIPO_AJUSTE = 3;
    public static final int TIPO_DEVOLUCION = 4;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "hora", nullable = false)
    private LocalTime hora;

    @Column(name = "concepto", nullable = false, length = 100)
    private String concepto;

    @Column(name = "existencia_anterior", nullable = false)
    private Integer existenciaAnterior;

    @Column(name = "tipo", nullable = false)
    private Integer tipo;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "existencia_posterior", nullable = false)
    private Integer existenciaPosterior;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto idProducto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario idUsuario;

}
