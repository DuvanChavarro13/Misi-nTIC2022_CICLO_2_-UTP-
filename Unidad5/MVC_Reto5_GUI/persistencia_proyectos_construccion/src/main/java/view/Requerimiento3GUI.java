package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import java.awt.GridLayout;

import model.vo.MaterialRankeadoCompras;
import java.util.ArrayList;

public class Requerimiento3GUI extends JFrame{
    
    //Atributos -> Orientados a componentes intermedios y comoponentes
    private JTable jtMateriales;

    //Constructor realizar la composición de la ventana
    public Requerimiento3GUI(ArrayList<MaterialRankeadoCompras> materiales) {
        
        //Propiedades del frame
        setTitle("---- RANKING MATERIALES (COMPRAS) ----");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); //-> Que se cierre solo esa ventana pero no la aplicación


        //Construcción de la tabla que presentará los proyectos
        String[] encabezado = {"Nombre Material", "Importado", "Nº Compras"};
        this.jtMateriales = new JTable(formatoRegistros(materiales, encabezado.length), encabezado);
        
        //Para darle scroller 
        JScrollPane sp = new JScrollPane(this.jtMateriales);

        //Componente intermedio
        JPanel panel = new JPanel(new GridLayout());
        panel.setBorder(new TitledBorder("Ranking de materiales por número de compras"));
        panel.add(sp);
        // //Componente intermedio al contenedor
        getContentPane().add(panel);

        //Mostrar ventana/frame
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private String[][] formatoRegistros(ArrayList<MaterialRankeadoCompras> materiales, int numeroEncabezados){
        //Declaración del contenedor de retorno
        String[][] registros = new String[materiales.size()][numeroEncabezados];
        
        //Desenvuelve los objetos de la colección
        for (int i = 0; i < materiales.size(); i++) {
            registros[i][0] = materiales.get(i).getNombreMaterial();
            registros[i][1] = materiales.get(i).getImportado(); 
            registros[i][2] = String.valueOf(materiales.get(i).getNumeroCompras());
        }
        
        //Retorna los registros en formato JTable
        return registros;
    }

}
