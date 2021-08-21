package controller;

import java.util.ArrayList;

import javax.swing.JButton;

import java.sql.SQLException;

import model.vo.ProyectoRankeadoCompras;
import model.dao.ProyectoRankeadoComprasDao;
import model.vo.BancoRankeadoAreaPromedio;
import model.dao.BancoRankeadoAreaPromedioDao;
import model.vo.MaterialRankeadoCompras;
import model.dao.MaterialRankeadoComprasDao;

//Vista
import view.MenuPrincipalGUI;
import view.Requerimiento1GUI;
import view.Requerimiento2GUI;
import view.Requerimiento3GUI;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ControladorRequerimientosReto4 implements ActionListener {
    
    //Alojar intancias de la clase del modelo DAO 
    private final ProyectoRankeadoComprasDao comprasDao;
    private final BancoRankeadoAreaPromedioDao bancoDao;
    private final MaterialRankeadoComprasDao materialDao;

    //Alojar objetos de la vista
    private final MenuPrincipalGUI menuPrincipalGUI;
    private Requerimiento1GUI requerimiento1GUI;
    private Requerimiento2GUI requerimiento2GUI;
    private Requerimiento3GUI requerimiento3GUI;


    //Constructores
    public ControladorRequerimientosReto4(){
        
        //Instancia de las compras rankeadas
        this.comprasDao = new ProyectoRankeadoComprasDao();
        //Instancia del banco rankeado
        this.bancoDao = new BancoRankeadoAreaPromedioDao();
        //Instancia de los materiales rankeados 
        this.materialDao = new MaterialRankeadoComprasDao();
        //Intanciar las interfaces
        this.menuPrincipalGUI = new MenuPrincipalGUI();

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

    //Controlador iniciando la aplicación
    public void iniciarAplicacion(){
        this.menuPrincipalGUI.iniciarGUI(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Obtener el evento asociado al botón 
        String actionCommand =  ((JButton)e.getSource()).getActionCommand();
        
        switch (actionCommand) {

            case "ProyectosRankeados":
                System.out.println("=== INTERFAZ PROYECTOS RANKEADOS ===");

                try{
                    ArrayList<ProyectoRankeadoCompras> proyectos = new ArrayList<ProyectoRankeadoCompras>();
                    proyectos = this.comprasDao.rankingProyectosComprasDescendente10();
                
                    this.requerimiento1GUI = new Requerimiento1GUI(proyectos);

                }catch(SQLException eProyectosCompras){
                    System.err.println("Error cargando RQ1 en la ventana: " + eProyectosCompras);
                }
                
            break;


            case "BancosRankeados":
                System.out.println("$$$ INTERFAZ BANCOS RANKEADOS $$$");
                try{
                    ArrayList<BancoRankeadoAreaPromedio> bancos = new ArrayList<BancoRankeadoAreaPromedio>();
                    bancos = this.bancoDao.rankingBancosAreaPromedioDescendente();
                
                    this.requerimiento2GUI = new Requerimiento2GUI(bancos);

                }catch(SQLException eBancosArea){
                    System.err.println("Error cargando RQ2 en la ventana: " + eBancosArea);
                }
            break;


            case "MaterialRankeado":
                System.out.println("--- INTERFAZ MATERIALES RANKEADOS ---");
                try{
                    ArrayList<MaterialRankeadoCompras> materiales = new ArrayList<MaterialRankeadoCompras>();
                    materiales = this.materialDao.rankingMaterialesComprasDescendente();
                
                    this.requerimiento3GUI = new Requerimiento3GUI(materiales);

                }catch(SQLException eMateriales){
                    System.err.println("Error cargando RQ3 en la ventana: " + eMateriales);
                }
            break;
        }
    }

}
