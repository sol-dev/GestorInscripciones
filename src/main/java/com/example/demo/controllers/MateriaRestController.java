package com.example.demo.controllers;

import java.util.List;

import com.example.demo.entities.Materia;
import com.example.demo.entities.Profesor;
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


@CrossOrigin(origins = "http://localhost:3000")
@RestController
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

    //update materia, se debe enviar json con id y los atributos a modificar
    @PostMapping(value = "/update", consumes = "application/json")
    public Object updateMateria(@RequestBody Materia materia){
        Object obj =null;
        Materia matAux= materiaService.findMateriaById(materia.getIdMateria());
        if(matAux!=null){
            if(materia.getNombre()==null)
                materia.setNombre(matAux.getNombre());
            if(materia.getCupoAlumnos()==0)
                materia.setCupoAlumnos(matAux.getCupoAlumnos());
            if(materia.getDia()==null)
                materia.setDia(matAux.getDia());
            /*if(materia.getHoraInicio()== null)
                materia.setHoraInicio(matAux.getHoraInicio());
            if(materia.getHoraFin()==null)
                materia.setHoraFin(matAux.getHoraFin()); */
            if(materia.getDescripcion()==null)
                materia.setDescripcion(matAux.getDescripcion());
            if(materia.getProfesor()==null)
                materia.setProfesor(matAux.getProfesor());
            System.out.println("Materia a actualizar: " + materia.toString());
            obj = materiaService.saveMateria(materia);
        }
        return obj;
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

 

    //agregar profesor a materia, debe enviarse el profesor existente
    @PostMapping(value = "/asignarProfesor", consumes = "application/json")
    public Object asignarProfesor(@RequestParam("idMateria") int idMateria,@RequestBody Profesor profesor ){
        Materia materia = materiaService.findMateriaById(idMateria);
        System.out.println(materia.toString());
        System.out.println(profesor.toString());
        profesor.setActivo(true);
        String mensaje ="Profesor "+profesor.getApellido()+" "+profesor.getNombre()+" asignado a materia: "+ materia.getNombre();
        if(materia!=null){
            if(profesor!=null){
                materia.setProfesor(profesor);
                materiaService.saveMateria(materia);
            }else{
                mensaje ="Error: no se encontro el profesor";
            }
        }else{
            mensaje ="Error: no se encontro la materia";
        }
        System.out.println(mensaje);
        return materia;
    }

}
