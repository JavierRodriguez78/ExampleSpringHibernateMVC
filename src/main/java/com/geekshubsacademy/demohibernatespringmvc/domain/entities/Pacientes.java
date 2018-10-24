package com.geekshubsacademy.demohibernatespringmvc.domain.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="pacientes")
public class Pacientes implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String historiaClinica;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String apellido;

    @NotNull
    @Column(name="createdAt")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;

    public Pacientes() {
    }

    public Pacientes(@NotEmpty String historiaClinica, @NotEmpty String nombre, @NotEmpty String apellido, @NotNull Date createdAt) {
        this.historiaClinica = historiaClinica;
        this.nombre = nombre;
        this.apellido = apellido;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(String historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Pacientes{" +
                "id=" + id +
                ", historiaClinica='" + historiaClinica + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
