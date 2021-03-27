package com.example.demo.services.implementation;

import java.util.List;

import com.example.demo.entities.Materia;
import com.example.demo.services.IMateriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.IMateriaRepository;

@Service("materiaService")
public class MateriaService implements IMateriaService {
    
    @Autowired
    @Qualifier("MateriaRepository")
    private IMateriaRepository iMateriaRepository;

    //métodos
    public Object saveMateria(Materia materia) {
        return iMateriaRepository.saveAndFlush(materia);
    }

    public Materia findMateriaById(int id) {
        return iMateriaRepository.findById(id).get();
    }

    public void deleteMateria(Integer id) {
        iMateriaRepository.delete(iMateriaRepository.findById(id).get());
    }
 
    public Materia findByNombre(String nombre) {
        return iMateriaRepository.findByNombre(nombre);
    }
    
    public List<Materia> findAll() {
        return iMateriaRepository.findAll();
    }

    

}
