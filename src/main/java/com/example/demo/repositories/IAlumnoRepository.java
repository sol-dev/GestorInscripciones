package com.example.demo.repositories;

import java.io.Serializable;

import com.example.demo.entities.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("AlumnoRepository")
public interface IAlumnoRepository extends JpaRepository<Alumno, Serializable> {
    
    @Query("SELECT a FROM Alumno a WHERE a.legajo = :_legajo ")
    public abstract Alumno findByLegajo(@Param("_legajo") String legajo);

    @Query("SELECT a FROM Alumno a WHERE a.dni = :_dni ")
    public abstract Alumno findByDni(@Param("_dni") Long dni);


}
