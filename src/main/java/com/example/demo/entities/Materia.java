package com.example.demo.entities;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

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
    //@JsonIgnoreProperties("materias") //al traer el profesor, no trae las materias
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Profesor profesor;

    
    @JsonIgnoreProperties("materias")
    @ManyToMany(mappedBy = "materias")
    private Set<Alumno> alumnos = new HashSet<Alumno>();

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

    public Materia(int idMateria, String nombre, int cupoAlumnos, String dia, Time horaInicio, Time horaFin,
            String descripcion, Profesor profesor, Set<Alumno> alumnos) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.cupoAlumnos = cupoAlumnos;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.descripcion = descripcion;
        this.profesor = profesor;
        this.alumnos = alumnos;
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

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public String toString() {
        return "Materia [cupoAlumnos=" + cupoAlumnos + ", descripcion=" + descripcion + ", dia=" + dia + ", horaFin="
                + horaFin + ", horaInicio=" + horaInicio + ", idMateria=" + idMateria + ", nombre=" + nombre
                + ", profesor=" + profesor + "]";
    }


}
