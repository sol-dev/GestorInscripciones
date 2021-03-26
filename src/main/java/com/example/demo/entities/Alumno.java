package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "alumno")             //para herencia, seria la subclase, la anotacion de abajo
@PrimaryKeyJoinColumn(referencedColumnName="idUsuario") //mismo nombre que el atributo de la superclase
public class Alumno extends Usuario{
    
    @Column(name = "legajo")
    private String legajo;
    
    public Alumno(){}

    public Alumno(int idUsuario, String nombre, String apellido, long dni, String legajo) {
        super(idUsuario, nombre, apellido, dni);
        this.legajo = legajo;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    @Override
    public String toString() {
        return "Alumno [legajo=" + legajo + "]";
    }

    
}
