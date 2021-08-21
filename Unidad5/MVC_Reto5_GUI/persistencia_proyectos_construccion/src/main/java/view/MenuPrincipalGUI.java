package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.awt.GridLayout;
import java.awt.Image;

import controller.ControladorRequerimientosReto4;


public class MenuPrincipalGUI extends JFrame{
    
    //Atributos -> Orientados a componentes intermedios y comoponentes
    private JButton btnR1;
    private JButton btnR2;
    private JButton btnR3;

    //Constructor realizar la composición de la ventana
    public MenuPrincipalGUI() {

    }

    private ImageIcon redimensionarIcono(ImageIcon icono, int pixeles){
        Image image = icono.getImage();
        Image newimg = image.getScaledInstance(pixeles, pixeles, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newimg);
    }

    //Metodo para composición
    public void iniciarGUI(ControladorRequerimientosReto4 controlador){

        //Propiedades del frame
        setTitle("RETO 5 INTERFAZ (GUI)");
        setDefaultCloseOperation(EXIT_ON_CLOSE); //-> Que toda la aplicación de cierre al cerrarse esta ventana

        //Agregar componentes
        btnR1 = new JButton(redimensionarIcono(new ImageIcon("persistencia_proyectos_construccion/img/project.png"), 50));
        btnR1.setText("  Proyectos Rankeado Compras");
        btnR1.addActionListener(controlador); // Quien escuchará el botón? 
        btnR1.setActionCommand("ProyectosRankeados"); // Lo que debe decur para que se ejecute el botón
        

        btnR2 = new JButton(redimensionarIcono(new ImageIcon("persistencia_proyectos_construccion/img/bank.png"), 50));
        btnR2.setText("  Bancos Rankeados ÁreaPromedio");
        btnR2.addActionListener(controlador); 
        btnR2.setActionCommand("BancosRankeados");


        btnR3 = new JButton(redimensionarIcono(new ImageIcon("persistencia_proyectos_construccion/img/material.png"), 50));
        btnR3.setText("  Material Rankeado Compras");
        btnR3.addActionListener(controlador); 
        btnR3.setActionCommand("MaterialRankeado");


         //Componente intermedio
        JPanel panel = new JPanel(new GridLayout(3,1));
        panel.add(btnR1);
        panel.add(btnR2);
        panel.add(btnR3);
        //Componente intermedio al contenedor
        getContentPane().add(panel);

        //Mostrar ventana/frame
        setSize(450, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
