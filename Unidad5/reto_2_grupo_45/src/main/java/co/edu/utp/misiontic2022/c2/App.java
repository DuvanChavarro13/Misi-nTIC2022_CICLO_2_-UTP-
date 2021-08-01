package co.edu.utp.misiontic2022.c2;

import java.util.ArrayList;
/**
 CARRITO COMPRAS VERDURAS 
 */
public class App 
{
    public static void main( String[] args )
    {
        ArrayList<Verdura> verduras = new ArrayList<>();
        verduras.add(new Verdura("Papa",3.8,2000,true));
        verduras.add(new Convencional("Cebolla Morada", 4.0,0.1,2,400,true)); 
        verduras.add(new Organica("Tomate Chonto", 2.0,280)); verduras.add(new Organica("Cilantro", 1.7,95));
        verduras.add(new Organica("Aguacate",6.0,0.1,0.06));
        CarritoCompras carritoCompras = new CarritoCompras(verduras);
        carritoCompras.mostrarTotales();

        System.out.println();

        ArrayList<Verdura> verduras2 = new ArrayList<>(); 
        verduras2.add(new Convencional("Maíz", 3.0,1000,true)); 
        verduras2.add(new Verdura("Albahaca", 1.7,80)); 
        verduras2.add(new Organica("Apio",3.3,0.1,0.06)); 
        verduras2.add(new Verdura("Arracacha",2.1,2000,false)); 
        CarritoCompras carritoCompras2 = new CarritoCompras(verduras2); 
        carritoCompras2.mostrarTotales();
    }
}
