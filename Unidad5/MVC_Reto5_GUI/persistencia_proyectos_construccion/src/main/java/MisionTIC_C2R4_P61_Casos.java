
import java.sql.Connection;
import java.sql.SQLException;
import util.JDBCUtilities;
import view.VistaRequerimientosReto4;
import controller.ControladorRequerimientosReto4;

public class MisionTIC_C2R4_P61_Casos {

    public static void main(String[] args) {
       
       //Inicio de la aplicación con GUI
       ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();
       controlador.iniciarAplicacion();
       
        /*
        try(Connection conexion = JDBCUtilities.getConnection()){
        
            //CASOS DE PRUEBA 
            //Requerimiento 1 - Reto3
            VistaRequerimientosReto4.requerimiento1();
            System.out.println();
            //Requerimiento 3 - Reto3
            VistaRequerimientosReto4.requerimiento3();
            System.out.println();
            //Requerimiento 5 - Reto3
            VistaRequerimientosReto4.requerimiento5();
            System.out.println();

        }catch( SQLException e ){
            System.err.println("Error iniciando conexion: " + e);
        } 
        */
    }
    
}
