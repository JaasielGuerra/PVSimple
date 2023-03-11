package com.guerra.pvsimple.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "cuenta_proveedor")
@Getter
@Setter
public class CuentaProveedor implements Serializable {

    public static final int ESTADO_ACTIVO = 1;
    public static final int ESTADO_INACTIVO = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "comentario", length = 100)
    private String comentario;

    @Column(name = "cargo", nullable = false)
    private Double cargo;

    @Column(name = "abono", nullable = false)
    private Double abono;

    @Column(name = "saldo", nullable = false)
    private Double saldo;

    @Column(name = "estado", nullable = false)
    private Integer estado;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_compra", nullable = false)
    private Compra idCompra;

}

