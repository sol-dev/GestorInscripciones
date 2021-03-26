package com.example.demo.entities;

import javax.persistence.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "profesor")
@PrimaryKeyJoinColumn(referencedColumnName="idUsuario")
public class Profesor extends Usuario {
    
    @Column(name = "activo")
    private boolean activo;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "profesor")
    private Set<Materia> materias = new HashSet<Materia>();

    public Profesor(){}

    public Profesor(int idUsuario, String nombre, String apellido, long dni, boolean activo) {
        super(idUsuario, nombre, apellido, dni);
        this.activo = activo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Profesor [activo=" + activo + "]";
    }

    
}
