package com.example.demo.services.implementation;

import java.util.List;

import com.example.demo.entities.Alumno;
import com.example.demo.repositories.IAlumnoRepository;
import com.example.demo.services.IAlumnoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("alumnoService")
public class AlumnoService implements IAlumnoService{
    
    @Autowired
    @Qualifier("AlumnoRepository")
    private IAlumnoRepository iAlumnoRepository;

    public Alumno findAlumnoById(int id) {
        return iAlumnoRepository.findById(id).get();
    }

    public void deleteAlumno(Integer id) {
        iAlumnoRepository.delete(iAlumnoRepository.findById(id).get());
    }

    //new & update
    public Object saveAlumno(Alumno alumno) {
        return iAlumnoRepository.saveAndFlush(alumno);
    }

    
    public Alumno findByDni(Long dni) {
        return iAlumnoRepository.findByDni(dni);
    }
   

    public Alumno findByLegajo(String legajo) {
        return iAlumnoRepository.findByLegajo(legajo);
    }

    public List<Alumno> findAll() {
        return iAlumnoRepository.findAll();
    }

   
    public void anularInscripcion(int idAlumno, int idMateria) {
        iAlumnoRepository.removeMateria(idAlumno, idMateria);
    }

}
