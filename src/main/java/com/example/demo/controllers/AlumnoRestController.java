package com.example.demo.controllers;

import java.util.List;

import com.example.demo.entities.Alumno;
import com.example.demo.services.IAlumnoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alumno")
public class AlumnoRestController {
    
    //servicio
    @Autowired
    @Qualifier("alumnoService")
    private IAlumnoService alumnoService;

    //nuevo alumno
    //recordar enviar json completo con datos del usuario, sin id
    @PostMapping(value = "/new",consumes = "application/json")
    public Object newAlumno(@RequestBody Alumno alumno){
        System.out.println("Nuevo Alumno a registrar: "+ alumno.toString());
        return alumnoService.saveAlumno(alumno);
    }

    //update alumno
    //recordar enviar json completo con datos del usuario, sin id
    @PostMapping(value = "/update", consumes = "application/json")
    public Object updateAlumno(@RequestBody Alumno alumno){
        System.out.println("Alumno a actualizar: " + alumno.toString());
        return alumnoService.saveAlumno(alumno);
    }

    //borrar materia
    @DeleteMapping(value = "/delete")
    public String deleteAlumno(@RequestParam("id")Integer id){
        alumnoService.deleteAlumno(id);
        return ("Alumno eliminado");
    }

    //traer por id
    @GetMapping("/id")
    public Alumno findById(@RequestParam("id") int id){
        return alumnoService.findAlumnoById(id);
    }

    //traer todos los alumnos
    @GetMapping("/all")
    public List<Alumno> findAll(){
        return alumnoService.findAll();
    }


    
    //traer por dni
    @GetMapping("/dni")
    public Alumno findByDni(@RequestParam("dni") long dni){
        return alumnoService.findByDni(dni);
    }
    

    //traer por legajo
    @GetMapping("/legajo")
    public Alumno findByLegajo(@RequestParam("legajo") String legajo){
        return alumnoService.findByLegajo(legajo);
    }   

}
