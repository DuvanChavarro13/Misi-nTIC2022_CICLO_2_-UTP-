package model.dao;

import model.vo.BancoRankeadoAreaPromedio;
import java.util.ArrayList; 
import util.JDBCUtilities; 
import java.sql.SQLException; 
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class BancoRankeadoAreaPromedioDao {
    
    //Obtener los bancos rankeados por área promedio de los proyectos que respaldan
    public ArrayList<BancoRankeadoAreaPromedio> rankingBancosAreaPromedioDescendente() throws SQLException{

        ArrayList<BancoRankeadoAreaPromedio> respuesta = new ArrayList<BancoRankeadoAreaPromedio>();
        Connection conexion = null;

        try{
            conexion = JDBCUtilities.getConnection();

            String consulta = "SELECT " +  
                                "p.Banco_Vinculado, " +
                                "AVG(t.Area_Max) AS Area_Promedio " + 
                              "FROM Proyecto AS p " +  
                              "INNER JOIN Tipo AS t " +
                                "ON p.ID_Tipo = t.ID_Tipo " +
                              "GROUP BY p.Banco_Vinculado " +
                              "ORDER BY Area_Promedio DESC";
            
            PreparedStatement statement = conexion.prepareStatement(consulta);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
    
                BancoRankeadoAreaPromedio banco = new BancoRankeadoAreaPromedio();

                banco.setBancoVinculado(resultSet.getString("Banco_Vinculado"));
                banco.setAreaPromedio(resultSet.getDouble("Area_Promedio"));

                respuesta.add(banco);
            }

            resultSet.close();
            statement.close();

        }catch(SQLException e){
            System.err.println("Error consultando bancos rankeados areaMax promedio" + e);
        
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }

        return respuesta;
    }

}
