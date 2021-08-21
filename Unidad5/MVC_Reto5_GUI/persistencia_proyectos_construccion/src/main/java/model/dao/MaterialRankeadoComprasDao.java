package model.dao;

import util.JDBCUtilities;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import model.vo.MaterialRankeadoCompras;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MaterialRankeadoComprasDao {

    //Obtener los importados más comprados
    public ArrayList<MaterialRankeadoCompras> rankingMaterialesComprasDescendente() throws SQLException {

        ArrayList<MaterialRankeadoCompras> respuesta = new ArrayList<MaterialRankeadoCompras>();
        Connection conexion = null;

        try{
            conexion = JDBCUtilities.getConnection();

            String consulta = "SELECT " +
                                "mc.Nombre_Material, " +
                                "mc.Importado, " +
                                "COUNT(mc.ID_MaterialConstruccion * c.Cantidad) AS No_Compras " +
                              "FROM MaterialConstruccion AS mc " +
                              "INNER JOIN Compra AS c " +
                                "ON c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion " +
                              "WHERE mc.Importado IN ('si', 'Si') " +
                              "GROUP BY mc.Nombre_Material " +
                              "ORDER BY " +
                                "No_Compras DESC, " +
                                "mc.Nombre_Material ASC ";

            PreparedStatement statement = conexion.prepareStatement(consulta);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                MaterialRankeadoCompras material = new MaterialRankeadoCompras();

                material.setNombreMaterial(resultSet.getString("Nombre_Material"));
                material.setImportado(resultSet.getString("Importado"));
                material.setNumeroCompras(resultSet.getInt("No_Compras"));

                respuesta.add(material);
            }

        }catch(SQLException e){
            System.err.println("Error consultando material rankeado por compras" + e);
        
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }
        return respuesta;
        
    }
    
}
