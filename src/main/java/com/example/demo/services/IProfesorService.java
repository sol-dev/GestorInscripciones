package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Profesor;

public interface IProfesorService {
    
    public Profesor findProfesorById(final int id);
    
    public Profesor findByDni(Long dni);

    public Object saveProfesor(Profesor profesor);

    public void deleteProfesor(Integer id);

    public List<Profesor> findAll();

    public List<Profesor> findProfesoresActivos();

}
