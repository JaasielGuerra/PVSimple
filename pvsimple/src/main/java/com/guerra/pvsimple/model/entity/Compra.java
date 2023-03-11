package com.guerra.pvsimple.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "compra")
@Getter
@Setter
public class Compra implements Serializable {

    public static final int ESTADO_REALIZADA = 1;
    public static final int ESTADO_ANULADA = 0;
    public static final int TIPO_CONTADO = 1;
    public static final int TIPO_CREDITO = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "hora", nullable = false)
    private LocalTime hora;

    @Column(name = "documento", nullable = false, length = 45)
    private String documento;

    @Column(name = "total", nullable = false)
    private Double total;

    @Column(name = "estado", nullable = false)
    private Integer estado;

    @Column(name = "tipo", nullable = false)
    private Integer tipo;

    @Column(name = "saldo", nullable = false)
    private Double saldo;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proveedor", nullable = false)
    private Proveedor idProveedor;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario idUsuario;


}
