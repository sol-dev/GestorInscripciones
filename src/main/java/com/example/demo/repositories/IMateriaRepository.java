package com.example.demo.repositories;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.demo.entities.*; 


@Repository("MateriaRepository")
//public interface IMateriaRepository extends CrudRepository<Materia, Integer> {

public interface IMateriaRepository extends JpaRepository<Materia, Serializable> {
    
    @Query("SELECT m FROM Materia m WHERE m.nombre = :_nombre ")
    public abstract Materia findByNombre(@Param("_nombre") String nombre);

}
