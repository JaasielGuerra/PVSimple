package com.guerra.pvsimple.model.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "abono_proveedor")
@Getter
@Setter
public class AbonoProveedor implements Serializable {

    public static final int ESTADO_ACTIVO = 1;
    public static final int ESTADO_ELIMINADO = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "monto", nullable = false)
    private Double monto;

    @Column(name = "documento", length = 50)
    private String documento;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_compra", nullable = false)
    private Compra idCompra;

    @Column(name = "estado", nullable = false)
    private Integer estado;

}
