package com.na.backend.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @Column(name = "ad_codigo")
    private String codigo;

    @Column(name = "ad_nombre")
    private String nombre;

    @Column(name = "ad_apellido")
    private String apellido;
    @Column(name = "ad_fechaRegistro")
    private LocalDate fechaRegistro;

    @Column(name = "ad_correo")
    private String correo;

    @Column(name = "ad_telefono")
    private String telefono;

    @Column(name = "ad_edad")
    private int edad;

    @Column(name = "ad_fechanacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "ad_estado")
    private boolean estado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ad_usuario", referencedColumnName = "us_codigo")
    private Usuario usuario;

   

}
