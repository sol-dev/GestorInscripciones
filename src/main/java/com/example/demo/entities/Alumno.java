package com.example.demo.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "alumno")             //para herencia, seria la subclase, la anotacion de abajo
@PrimaryKeyJoinColumn(referencedColumnName="idUsuario") //mismo nombre que el atributo de la superclase
public class Alumno extends Usuario{
    
    @Column(name = "legajo")
    private String legajo;
    
    @JoinTable(
        name = "alumno_x_materia",
        joinColumns = @JoinColumn(name="fk_alumno", nullable = false),
        inverseJoinColumns = @JoinColumn(name ="fk_materia", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("alumnos")
    private Set<Materia> materias = new HashSet<Materia>();


    public Alumno(){}

    public Alumno(int idUsuario, String nombre, String apellido, long dni, String legajo) {
        super(idUsuario, nombre, apellido, dni);
        this.legajo = legajo;
    }

    public Alumno(int idUsuario, String nombre, String apellido, long dni, String legajo, Set<Materia> materias) {
        super(idUsuario, nombre, apellido, dni);
        this.legajo = legajo;
        this.materias = materias;
    }
    
    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public Set<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(Set<Materia> materias) {
        this.materias = materias;
    }

    @Override
    public String toString() {
        return "Alumno [legajo=" + legajo + "]";
    }

    
}
