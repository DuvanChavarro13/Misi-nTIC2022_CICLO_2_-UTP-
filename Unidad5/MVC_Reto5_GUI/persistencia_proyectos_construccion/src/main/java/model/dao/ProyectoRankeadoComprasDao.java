package model.dao;

import model.vo.ProyectoRankeadoCompras;
import java.util.ArrayList; 
import util.JDBCUtilities; 
import java.sql.SQLException; 
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ProyectoRankeadoComprasDao {

    //Obtener los 10 proyectos rankeados según las compras
    public ArrayList<ProyectoRankeadoCompras> rankingProyectosComprasDescendente10() throws SQLException {

        ArrayList<ProyectoRankeadoCompras> respuesta = new ArrayList<ProyectoRankeadoCompras>();
        Connection conexion = null;

        try{
            conexion = JDBCUtilities.getConnection();

            String consulta = "SELECT " + 
                                "p.ID_Proyecto, " +
                                "p.Clasificacion, " +
                                "SUM(c.Cantidad * mc.Precio_Unidad) AS Gasto_Compras, " + 
                                "p.Serial " + 
                              "FROM Proyecto AS p " +
                              "INNER JOIN Compra AS c " +
                                "ON p.ID_Proyecto = c.ID_Proyecto " +
                              "INNER JOIN MaterialConstruccion AS mc " +
                                "ON mc.ID_MaterialConstruccion = c.ID_MaterialConstruccion " +
                              "GROUP BY p.ID_Proyecto " +
                              "ORDER BY Gasto_Compras DESC " +
                              "LIMIT 10 ";

            PreparedStatement statement = conexion.prepareStatement(consulta);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                //Cargar registro actual en un Valu Object
                ProyectoRankeadoCompras compras = new ProyectoRankeadoCompras();

                compras.setIdProyecto(resultSet.getInt("ID_Proyecto"));
                compras.setClasificacion(resultSet.getString("Clasificacion"));
                compras.setGastoCompras(resultSet.getInt("Gasto_Compras"));
                compras.setSerial(resultSet.getString("Serial"));

                respuesta.add(compras);
            }

            resultSet.close();
            statement.close();

        }catch(SQLException e){
            System.err.println("Error consultando proyectos rankeados de las compras" + e);
        
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }

        return respuesta;
        
    } 
 
}
