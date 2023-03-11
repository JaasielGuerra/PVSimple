package com.guerra.pvsimple.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "venta")
@Getter
@Setter
public class Venta implements Serializable {

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

    @Column(name = "total", nullable = false)
    private Double total;

    @Column(name = "total_ganancia", nullable = false)
    private Double totalGanancia;

    @Column(name = "tipo", nullable = false)
    private Integer tipo;

    @Column(name = "estado", nullable = false)
    private Integer estado;

    @Column(name = "saldo", nullable = false)
    private Double saldo;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente idCliente;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario idUsuario;


}
