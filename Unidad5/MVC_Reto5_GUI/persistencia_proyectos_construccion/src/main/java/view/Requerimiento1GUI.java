package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import java.awt.GridLayout;

//import controller.ControladorRequerimientosReto4;

import model.vo.ProyectoRankeadoCompras;
import java.util.ArrayList;

public class Requerimiento1GUI extends JFrame{
    
    //Atributos -> Orientados a componentes intermedios y comoponentes
    private JTable jtProyectos;

    //Constructor realizar la composición de la ventana
    public Requerimiento1GUI(ArrayList<ProyectoRankeadoCompras> proyectos) {
        
        //Propiedades del frame
        setTitle("---- 10 PROYECTOS MAYOR GASTO ----");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); //-> Que se cierre solo esa ventana pero no la aplicación


        //Construcción de la tabla que presentará los proyectos
        String[] encabezado = {"ID Proyecto", "Clasificación", "Gasto Compras", "Serial"};
        this.jtProyectos = new JTable(formatoRegistros(proyectos, encabezado.length), encabezado);
        
        //Para darle scroller 
        JScrollPane sp = new JScrollPane(this.jtProyectos);

        //Componente intermedio
        JPanel panel = new JPanel(new GridLayout());
        panel.setBorder(new TitledBorder("Ranking Mayor Gasto Por Compras"));
        panel.add(sp);
        // //Componente intermedio al contenedor
        getContentPane().add(panel);

        
        //Mostrar ventana/frame
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private String[][] formatoRegistros(ArrayList<ProyectoRankeadoCompras> proyectos, int numeroEncabezados){
        //Declaración del contenedor de retorno
        String[][] registros = new String[proyectos.size()][numeroEncabezados];
        
        //Desenvuelve los objetos de la colección
        for (int i = 0; i < proyectos.size(); i++) {
            registros[i][0] = String.valueOf(proyectos.get(i).getIdProyecto()); 
            registros[i][1] = proyectos.get(i).getClasificacion();
            registros[i][2] = String.valueOf(proyectos.get(i).getGastoCompras()); 
            registros[i][3] = proyectos.get(i).getSerial();
        }
        
        //Retorna los registros en formato JTable
        return registros;
    }

}
