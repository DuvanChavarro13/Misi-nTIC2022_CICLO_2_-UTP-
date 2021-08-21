package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import java.awt.GridLayout;

import controller.ControladorRequerimientosReto4;

import model.vo.BancoRankeadoAreaPromedio;
import java.util.ArrayList;

public class Requerimiento2GUI extends JFrame{
    
    //Atributos -> Orientados a componentes intermedios y comoponentes
    private JTable jtBancos;

    //Constructor realizar la composición de la ventana
    public Requerimiento2GUI(ArrayList<BancoRankeadoAreaPromedio> bancos) {
        
        //Propiedades del frame
        setTitle("---- RANKING BANCOS (ÁREA PROMEDIO) ----");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); //-> Que se cierre solo esa ventana pero no la aplicación


        //Construcción de la tabla que presentará los proyectos
        String[] encabezado = {"Banco Vinculado", "Área Promedio"};
        this.jtBancos = new JTable(formatoRegistros(bancos, encabezado.length), encabezado);
        
        //Para darle scroller 
        JScrollPane sp = new JScrollPane(this.jtBancos);

        //Componente intermedio
        JPanel panel = new JPanel(new GridLayout());
        panel.setBorder(new TitledBorder("Ranking de bancos: Promedio de proyectos respaldados"));
        panel.add(sp);
        // //Componente intermedio al contenedor
        getContentPane().add(panel);

        
        //Mostrar ventana/frame
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private String[][] formatoRegistros(ArrayList<BancoRankeadoAreaPromedio> bancos, int numeroEncabezados){
        //Declaración del contenedor de retorno
        String[][] registros = new String[bancos.size()][numeroEncabezados];
        
        //Desenvuelve los objetos de la colección
        for (int i = 0; i < bancos.size(); i++) {
            registros[i][0] = bancos.get(i).getBancoVinculado(); 
            registros[i][1] = String.valueOf(bancos.get(i).getAreaPromedio());
        }
        
        //Retorna los registros en formato JTable
        return registros;
    }

}
