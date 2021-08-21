package controller;

import java.util.ArrayList;
import java.sql.SQLException;

//Model
import model.vo.Lider;
import model.dao.LiderDao;


//Esta clase será el intermediario
public class ControladorProyectosConstruccion {

    //El controlador alojará instancias de clases del modelo
    private final LiderDao liderDao;

    //Constructor 
    public ControladorProyectosConstruccion(){
        this.liderDao = new LiderDao();
    }

    //Cada requerimiento solicitado -> Casos de uso

    //Requerimiento 1 -> Listar todos los líderes
    public ArrayList<Lider> consultarTodosLideres() throws SQLException{
        return this.liderDao.consultarTodos();
    }


    
}
