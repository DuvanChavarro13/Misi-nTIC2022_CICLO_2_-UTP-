//Aplicación Proyectos Construcción
import java.sql.Connection;
import java.sql.SQLException;
import util.JDBCUtilities;
import view.MenuLider;

public class App {
    
    public static void main(String[] args) {

        //System.out.println("--Bienvenido Aplicación Proyectos Construcción");

        //Intentar conectarnos a la base de datos
        try(Connection conexion = JDBCUtilities.getConnection()){

            if(JDBCUtilities.estaVacia()){
                System.out.println("Se encuentra vacía!");
            }else{
                System.out.println("Base de datos encontrada!");
            }

            //Iniciar la aplicación -> Llamado al menú de inicio de la vista/view
            MenuLider.iniciar();


        }catch( SQLException e ){
            
            System.err.println("Error iniciando conexion: " + e);
        }
    }
}
