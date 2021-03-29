package com.example.demo.controllers;

import java.util.List;
import java.util.Set;

import com.example.demo.entities.Alumno;
import com.example.demo.entities.Materia;
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

    //inscribir alumno a materia, debe enviarse la materia existente completa(json) sin profesor ni alumnos
    @PostMapping(value = "/inscripcion", consumes = "application/json")
    public Object inscripcion(@RequestParam("idAlumno") int idAlumno, @RequestBody Materia materia ){
        Alumno alumno = alumnoService.findAlumnoById(idAlumno);
        System.out.println(alumno.toString());
        String mensaje ="Alumno "+alumno.getApellido()+" "+alumno.getNombre()+" inscripto en:" + materia.getNombre();
        
        //validar horario
        if(materia!=null && validarHorario(alumno.getMaterias(), materia)==true){
            if(materia.getAlumnos().contains(alumno)!=true){
                materia.getAlumnos().add(alumno);
            }
            if(alumno.getMaterias().contains(materia)!=true){
                alumno.getMaterias().add(materia);
            }
            alumnoService.saveAlumno(alumno);
            System.out.println(mensaje);
        }
        return alumno;
    }

    public boolean validarHorario(Set<Materia> materiasActuales, Materia materiaNueva){
        boolean ok=false; 
        int cantReal = materiasActuales.size();
        int cant = 0;
        for(Materia m: materiasActuales){    
            //si son el mismo dia
            if(m.getDia().compareTo(materiaNueva.getDia())==0){
                //si la hora de fin de las materias actuales está antes que la hora de inicio de la materia nueva
                // o si la hora fin de la materias nueva esta antes que la hora de inicio de las materias actuales
                if(m.getHoraFin().before(materiaNueva.getHoraInicio()) ==true ||  materiaNueva.getHoraFin().before(m.getHoraInicio())){
                    //la hora esta bien? : si
                    cant++;
                }
            }else{
                cant++;// si no es el mismo dia no puede coincidir
            }
        }
        // si no hay ningun problema de horarios
        if(cant == cantReal){
            ok=true;
        }
        return ok;
    } 
        
    

    //anular la inscripcion
    @PostMapping(value = "/anularInscripcion")
    public Object anularInscripcion(@RequestParam("idAlumno") int idAlumno, @RequestParam("idMateria") int idMateria){
        alumnoService.anularInscripcion(idAlumno, idMateria);
        return alumnoService.findAlumnoById(idAlumno);
    }

}
