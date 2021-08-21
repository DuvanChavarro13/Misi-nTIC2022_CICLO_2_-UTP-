package controller;

import java.util.ArrayList;
import java.sql.SQLException;

import model.vo.ProyectoRankeadoCompras;
import model.dao.ProyectoRankeadoComprasDao;
import model.vo.BancoRankeadoAreaPromedio;
import model.dao.BancoRankeadoAreaPromedioDao;
import model.vo.MaterialRankeadoCompras;
import model.dao.MaterialRankeadoComprasDao;


public class ControladorRequerimientosReto4 {
    
    //Alojar intancias de la clase del modelo DAO 
    private final ProyectoRankeadoComprasDao comprasDao;
    private final BancoRankeadoAreaPromedioDao bancoDao;
    private final MaterialRankeadoComprasDao materialDao;


    //Constructores
    public ControladorRequerimientosReto4(){
        
        //Instancia del banco rankeado
        this.bancoDao = new BancoRankeadoAreaPromedioDao();
        //Instancia de las compras rankeadas
        this.comprasDao = new ProyectoRankeadoComprasDao();
        //Instancia de los materiales rankeados 
        this.materialDao = new MaterialRankeadoComprasDao();
    }

    //Requerimiento 1 del Reto3 / Requerimiento 1 del Reto4
    public ArrayList<ProyectoRankeadoCompras> consultarProyectosCompras10() throws SQLException {
        return this.comprasDao.rankingProyectosComprasDescendente10();
    }


    //Requerimiento 3 del Reto3 / Requerimiento 2 del Reto4
    public ArrayList<BancoRankeadoAreaPromedio> consultarBancosRankeadosAreaPromedio() throws SQLException {
        return this.bancoDao.rankingBancosAreaPromedioDescendente();
    }

    
    //Requerimiento 5 del Reto3 / Requerimiento 3 del Reto4
    public ArrayList<MaterialRankeadoCompras> consultarMaterialesRankeadosCompras() throws SQLException {
        return this.materialDao.rankingMaterialesComprasDescendente();
    }

}
