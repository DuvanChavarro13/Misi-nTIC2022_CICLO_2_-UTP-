
import java.sql.Connection;
import java.sql.SQLException;
import util.JDBCUtilities;
import view.VistaRequerimientosReto4;

public class MisionTIC_C2R4_P61_Casos {

    public static void main(String[] args) {

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
    }
    
}
