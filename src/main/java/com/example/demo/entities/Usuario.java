package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name ="usuario")
@Inheritance( strategy = InheritanceType.JOINED ) //para herencia seria la superclase
public class Usuario {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(name ="nombre")
    private String nombre;

    @Column(name ="apellido")
    private String apellido;

    @Column(name="dni")
    private long dni;

    public Usuario(){}

    public Usuario(int idUsuario, String nombre, String apellido, long dni){
        this.idUsuario = idUsuario;
        this.nombre=nombre;
        this.apellido=apellido;
        this.dni=dni;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Usuario [apellido=" + apellido + ", dni=" + dni + ", idUsuario=" + idUsuario + ", nombre=" + nombre
                + "]";
    }

    




}