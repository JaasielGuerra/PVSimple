package com.guerra.pvsimple.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "categoria")
@Getter
@Setter
public class Categoria implements Serializable {

    public static final int ESTADO_ACTIVO = 1;
    public static final int ESTADO_INACTIVO = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;

    @Column(name = "estado", nullable = false)
    private Integer estado;

}
