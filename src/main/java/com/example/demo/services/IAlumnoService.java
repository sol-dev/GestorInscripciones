package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Alumno;

public interface IAlumnoService {
    
    public Alumno findAlumnoById(final int id);

    public Alumno findByDni(Long dni);

    public void deleteAlumno(Integer id);

    public Object saveAlumno(Alumno alumno);  
    
    public Alumno findByLegajo(String legajo);

    public List<Alumno> findAll();

    public void anularInscripcion(int idAlumno, int idMateria );
}

