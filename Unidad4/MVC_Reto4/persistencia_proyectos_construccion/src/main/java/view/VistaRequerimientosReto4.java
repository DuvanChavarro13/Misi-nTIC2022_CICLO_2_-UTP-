package view;

import java.util.ArrayList;

import java.sql.SQLException;
import controller.ControladorRequerimientosReto4;

import model.vo.ProyectoRankeadoCompras;
import model.vo.BancoRankeadoAreaPromedio;
import model.vo.MaterialRankeadoCompras;

public class VistaRequerimientosReto4 {
    
    public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();
    
     public static void requerimiento1(){
        System.out.println("-----10 Proyectos Mayor Gasto-------");       
        try{
            ArrayList<ProyectoRankeadoCompras> rankingProyectosCompras = controlador.consultarProyectosCompras10();
            System.out.println("ID_Proyecto Clasificación Gasto_Compras Serial"); 
            for (ProyectoRankeadoCompras compras : rankingProyectosCompras) {
                System.out.printf("%d %s %d %s %n",
                    compras.getIdProyecto(),
                    compras.getClasificacion(),
                    compras.getGastoCompras(),
                    compras.getSerial()
                );
            }
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }
    }


    public static void requerimiento3(){
        System.out.println("-----Ranking Descendente Bancos (Área Proyectos)-------");       
        try{
            ArrayList<BancoRankeadoAreaPromedio> rankingBancosArea = controlador.consultarBancosRankeadosAreaPromedio();
            System.out.println("Banco_Vinculado Area_Promedio");
            for (BancoRankeadoAreaPromedio bancos : rankingBancosArea) {
                System.out.printf("%s %f %n",
                    bancos.getBancoVinculado(),
                    bancos.getAreaPromedio()
                );      
            }
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }
    }

    
    public static void requerimiento5(){
        System.out.println("-----Ranking Descendente Materiales Importados (Compras)-------");       
        try{
            ArrayList<MaterialRankeadoCompras> rankingMaterialesImportados = controlador.consultarMaterialesRankeadosCompras();
            System.out.println("Nombre_Material Importado No_Compras");
            for (MaterialRankeadoCompras material : rankingMaterialesImportados) {
                System.out.printf("%s %s %d %n", 
                    material.getNombreMaterial(),
                    material.getImportado(),
                    material.getNumeroCompras()
                );
            }
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }
    }

}
