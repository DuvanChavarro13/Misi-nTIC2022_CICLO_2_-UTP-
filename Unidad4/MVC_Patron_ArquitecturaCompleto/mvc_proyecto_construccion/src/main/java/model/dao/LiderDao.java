package model.dao;

import model.vo.Lider;
import java.util.ArrayList; // -> ArrayList para coleecionar objetos 
import util.JDBCUtilities; // -> Para conectarnos a la base de datos 
import java.sql.SQLException; // Necesitamos manejar excepciones tambien
import java.sql.Connection;

//Clase para construir objetos de consulta -> Envolver esa consulta en un objeto con un comportamiento especifico
import java.sql.PreparedStatement;
//Clase para manejar la respuesta de BD -> Contenedor (iterador)
import java.sql.ResultSet;

//Esta clase solo va a tener funcionalidades -> Ese es el enfoque
public class LiderDao {
    
    //Operaciones CRUD -> Create, Read, Update, Delete
    //Consultar todos los líderes (READ)

    public ArrayList<Lider> consultarTodos() throws SQLException{

        //Contenedro de la respuesta -> Coleccion de líderes
        ArrayList<Lider> respuesta = new ArrayList<Lider>();
        Connection conexion = null;

        try{
            //Se hace la concexión a la clase JDBCUtilities
            conexion = JDBCUtilities.getConnection();
            
            //Luego de establecer la conexion, se hace la consulta -> Se debe volver un objeto
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Lider");

            //El objeto ResultSet proporciona varios métodos para obtener los datos de columna correspondientes a un fila.
            ResultSet resultSet = statement.executeQuery();

            //Para iterar el resulSet -> Ya que al ser un iterador (apuntador) y siempre y cuando pueda moverse
            // en cada registro, el devuelve verdadero o falso, la información que saca de allí, se puede sacar y cargarla
            // en un value object (vo).
            // LOS INTERADORES ARRANCAN EN EL INICIO DE UNA ESTRUCTURA DE DATOS (El inicio no es la primera posicion)
            // RESUMEN: Mueve apuntador por cada registro, cuando no hay más, retorna falso y se sale.
            while(resultSet.next()){
                //Cargar registro actual en un Valu Object
                Lider lider = new Lider();

                lider.setIdLider(resultSet.getInt("ID_Lider"));
                lider.setNombre(resultSet.getString("Nombre"));
                lider.setPrimerApellido(resultSet.getString("Primer_Apellido"));
                lider.setSegundoApellido(resultSet.getString("Segundo_Apellido"));
                lider.setSalario(resultSet.getInt("Salario"));
                lider.setClasificacion(resultSet.getDouble("Clasificacion"));

                respuesta.add(lider);
            }

            resultSet.close();
            statement.close();

        }catch(SQLException e){
            System.err.println("Error consultando líderes" + e);
        
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }

        //Se retorna la colección de VO's obtenida de la BD (Vacía, con un VO o muchos)
        return respuesta;
    }

}
