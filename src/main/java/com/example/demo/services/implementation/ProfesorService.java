package com.example.demo.services.implementation;

import java.util.List;

import com.example.demo.entities.Profesor;
import com.example.demo.repositories.IProfesorRepository;
import com.example.demo.services.IProfesorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service("profesorService")
public class ProfesorService implements IProfesorService {
    
    @Autowired
    @Qualifier("ProfesorRepository")
    private IProfesorRepository iProfesorRepository;


    public Profesor findProfesorById(final int id){
        return iProfesorRepository.findById(id).get();
    }
    
    public Profesor findByDni(Long dni){
        return iProfesorRepository.findByDni(dni);
    }

    //new & update
    public Object saveProfesor(Profesor profesor){
        return iProfesorRepository.saveAndFlush(profesor);
    }

    public void deleteProfesor(Integer id){
        iProfesorRepository.delete(iProfesorRepository.findById(id).get());
    }

    public List<Profesor> findAll(){
        return iProfesorRepository.findAll();
    }

    public List<Profesor> findProfesoresActivos(){
        return iProfesorRepository.findActivos();
    }
}
