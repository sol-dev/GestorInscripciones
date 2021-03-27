package com.example.demo.repositories;

import java.io.Serializable;
import java.util.List;

import com.example.demo.entities.Profesor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("ProfesorRepository")
public interface IProfesorRepository extends JpaRepository<Profesor, Serializable>{
    
    @Query("SELECT p FROM Profesor p WHERE p.dni = :_dni ")
    public abstract Profesor findByDni(@Param("_dni") Long dni);

    @Query("SELECT p FROM Profesor p WHERE p.activo= TRUE")
    public abstract List<Profesor> findActivos();
}

