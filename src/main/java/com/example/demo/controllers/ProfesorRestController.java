package com.example.demo.controllers;

import java.util.List;

import com.example.demo.entities.Profesor;
import com.example.demo.services.IProfesorService;

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
@RequestMapping("/profesor")
public class ProfesorRestController {
    
    //servicio
    @Autowired
    @Qualifier("profesorService")
    private IProfesorService profesorService;

    //nuevo profesor
    @PostMapping(value = "/new",consumes = "application/json")
    public Object newProfesor(@RequestBody Profesor profesor){
        profesor.setActivo(true);
        System.out.println("Nuevo profesor: "+ profesor);
        return profesorService.saveProfesor(profesor);
    }

    //actualizar profesor
    @PostMapping(value = "/update", consumes = "application/json")
    public Object updateProfesor(@RequestBody Profesor profesor){
        System.out.println("Profesor a actualizar: "+profesor.toString());
        return profesorService.saveProfesor(profesor);
    } 
    //eliminar
    @DeleteMapping(value = "/delete")
    public String deleteProfesor(@RequestParam("id")Integer id){
        profesorService.deleteProfesor(id);
        return ("Profesor Eliminado");
    }


    //traer por id
    @GetMapping(value = "/id")
    public Profesor findById(@RequestParam("id") int id){
        return profesorService.findProfesorById(id);
    }

    //traer por dni
    @GetMapping(value = "/dni")
    public Profesor findByDni(@RequestParam("dni")long dni){
        return profesorService.findByDni(dni);
    }

    //traer todos
    @GetMapping(value = "/all")
    public List<Profesor> findAll(){
        return profesorService.findAll();
    }

    //traer solo profesores activos
    @GetMapping(value = "/activos")
    public List<Profesor> findActivos(){
        return profesorService.findProfesoresActivos();
    }
}
