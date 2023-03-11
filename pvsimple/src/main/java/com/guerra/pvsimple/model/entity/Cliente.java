package com.guerra.pvsimple.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cliente")
@Getter
@Setter
public class Cliente implements Serializable {

    public static final int ESTADO_ACTIVO = 1;
    public static final int ESTADO_INACTIVO = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nit", nullable = false, length = 15)
    private String nit;

    @Column(name = "nombre_completo", nullable = false, length = 100)
    private String nombreCompleto;

    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;

    @Column(name = "telefono", length = 10)
    private String telefono;

    @Column(name = "limite_credito", nullable = false)
    private Double limiteCredito;

    @Column(name = "estado", nullable = false)
    private Integer estado;


}
