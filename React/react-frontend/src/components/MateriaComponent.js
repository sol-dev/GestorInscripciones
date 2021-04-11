import React from 'react';
import MateriaService from '../services/MateriaService';

class MateriaComponent extends React.Component{


    constructor(props){
        super(props)
        this.state = {
            materias:[]
        }
    }

    componentDidMount(){
        MateriaService.getAllMaterias().then( (response) => {
            this.setState({ materias: response.data })
        });
    }

    render(){
        return(
            <div>
                <h1 className="text-center"> Lista de Materias </h1>
                <table className="table table-striped">
                    <thead>
                        <tr>
                            <td>id Materia</td>
                            <td>Nombre</td>
                            <td>Cupo de Alumnos</td>
                            <td>Dia</td>
                            <td>Hora Inicio</td>
                            <td>Hora Fin</td>
                            <td>Descripcion</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.materias.map(
                                materia =>
                                <tr key={materia.idMateria}>
                                    <td> {materia.idMateria} </td>
                                    <td> {materia.nombre} </td>
                                    <td> {materia.cupoAlumnos} </td>
                                    <td> {materia.dia} </td>
                                    <td> {materia.horaInicio} </td>
                                    <td> {materia.horaFin} </td>
                                    <td> {materia.descripcion} </td>

                                </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>
        )
    }
} 
export default MateriaComponent;