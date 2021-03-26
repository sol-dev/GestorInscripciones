package com.example.demo.entities;

import java.sql.Time;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "materia")
public class Materia {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMateria;

    @Column(name = "nombre" , nullable = false)
    private String nombre;

    @Column(name = "cupo_alumnos", nullable = false)
    private int cupoAlumnos;

    @Column(name = "dia", nullable = false)
    private String dia;

    @Column(name = "hora_inicio")
    private Time horaInicio;

    @Column(name = "hora_fin")
    private Time horaFin;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    @JsonIgnoreProperties("materias") //cuando traiga el profesor, no me traiga las materias
    private Profesor profesor;

    public Materia(){}

    public Materia(int idMateria, String nombre, int cupoAlumnos, String dia, Time horaInicio, Time horaFin,
            String descripcion) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.cupoAlumnos = cupoAlumnos;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.descripcion = descripcion;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCupoAlumnos() {
        return cupoAlumnos;
    }

    public void setCupoAlumnos(int cupoAlumnos) {
        this.cupoAlumnos = cupoAlumnos;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return "Materia [cupoAlumnos=" + cupoAlumnos + ", descripcion=" + descripcion + ", dia=" + dia + ", horaFin="
                + horaFin + ", horaInicio=" + horaInicio + ", idMateria=" + idMateria + ", nombre=" + nombre
                + ", profesor=" + profesor + "]";
    }

    



}
