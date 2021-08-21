package util;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.io.File;

public class JDBCUtilities {

    //Atributos de clase para gestión de conexión con la base de datos      
    //private static final String UBICACION_BD = "ProyectosConstruccion.db";    
    private static final String UBICACION_BD = "C:\\basesDeDatosMinTic\\ProyectosConstruccion.db";    
    
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:" + UBICACION_BD;        
        return DriverManager.getConnection(url);
    }

    public static boolean estaVacia(){
        File archivo = new File(JDBCUtilities.UBICACION_BD);        
        return archivo.length() == 0;
    }
    
}
