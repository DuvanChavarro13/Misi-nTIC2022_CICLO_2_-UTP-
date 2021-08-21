package util;

//Librerias para conexion a base de datos 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Librerias para archivos
import java.io.File;

public class JDBCUtilities {

    //Ubicación de la base de datos que soporta este Software
    private static final String UBICACION_BD = "D:\\Users\\Desktop\\ProyectosJAva\\MVC _ConexionBD\\mvc_proyecto_construccion\\ProyectosConstruccion.db"; //Ruta absoluta
    
    //Metodo para proveer conexión
    public static Connection getConnection() throws SQLException {

        String url = "jdbc:sqlite:" + JDBCUtilities.UBICACION_BD;
        return DriverManager.getConnection(url);
    }
    
    //Metodo complemetario -> sqlite si no existe la base de datos, la crea (vacia)
        public static boolean estaVacia(){
            File archivo = new File(JDBCUtilities.UBICACION_BD);
            return archivo.length() == 0;
        }

    //Inicializacion de la base de datos

}
