package com.guerra.pvsimple.model.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuario")
@Getter
@Setter
public class Usuario implements Serializable {

    public static final int ESTADO_ACTIVO = 1;
    public static final int ESTADO_INACTIVO = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "user", nullable = false, length = 30)
    private String user;

    @Column(name = "password", nullable = false, length = 150)
    private String password;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

}
