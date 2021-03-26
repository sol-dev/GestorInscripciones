package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Materia;


public interface IMateriaService {

    public Object saveMateria(Materia materia);    

    public Materia findMateriaById(final int id);

    public void deleteMateria(Integer id);

    public Materia findByNombre(String nombre);

    public List<Materia> findAll();
}
