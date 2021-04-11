import axios from 'axios';

const MATERIA_REST_URL = "http://localhost:8080/materia/all";
//misma ruta que en postman

class MateriaService{

    getAllMaterias(){
        return axios.get(MATERIA_REST_URL);
    }
}

//exportar un objeto de esta clase
export default new MateriaService();