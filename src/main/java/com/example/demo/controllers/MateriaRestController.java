package com.example.demo.controllers;

import java.util.List;

import com.example.demo.entities.Materia;
import com.example.demo.services.IMateriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/materia")
public class MateriaRestController {
    
    //servicio
    @Autowired
    @Qualifier("materiaService")
    private IMateriaService materiaService;

    //nueva materia
    @PostMapping(value = "/new", consumes = "application/json")
    public Object newMateria(@RequestBody Materia materia){
        System.out.println("Nueva Materia a guardar: "+ materia.toString());
        return materiaService.saveMateria(materia);
    }

    //update materia
    @PostMapping(value = "/update", consumes = "application/json")
    public Object updateMateria(@RequestBody Materia materia){
        System.out.println("Materia a actualizar: " + materia.toString());
        return materiaService.saveMateria(materia);
    }

    //borrar materia
    @DeleteMapping(value = "/delete")
    public String deleteMateria(@RequestParam("id")Integer id){
        materiaService.deleteMateria(id);
        return ("Materia eliminada");
    }

    //traer por id
    @GetMapping("/id")
    public Materia findById(@RequestParam("id") int id){
        return materiaService.findMateriaById(id);
    }


    //traer por nombre
    @GetMapping("/nombre")
    public Materia findByNombre(@RequestParam("nombre") String nombre){
        return materiaService.findByNombre(nombre);
    }

    //traer todas las materias
    @GetMapping("/all")
    public List<Materia> findAll(){
        return materiaService.findAll();
    }

}
