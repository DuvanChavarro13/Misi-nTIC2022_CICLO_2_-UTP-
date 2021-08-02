package co.edu.utp.misiontic2022.c2;
import java.util.ArrayList;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println();
        ArrayList<Fruta> frutas = new ArrayList<>();
        frutas.add(new Fruta("Sandía",3.8,2000,true));
        frutas.add(new Convencional("Granadilla", 4.0,0.1,2,400,true));
        frutas.add(new Organica("Pitaya", 2.0,280));
        frutas.add(new Organica("Uchuva", 1.7,95));
        frutas.add(new Organica("Banano",6.0,0.1,0.06));
        Venta ventas = new Venta(frutas);
        ventas.mostrarTotales();

        System.out.println();
        ArrayList<Fruta> frutas2 = new ArrayList<>();
        frutas2.add(new Fruta("Papaya",3.0,1900));
        frutas2.add(new Fruta("Melón",3.6,1000));
        frutas2.add(new Convencional("Manzana", 3.0, 400, true));
        frutas2.add(new Convencional("Naranja", 2.4, 700, false));
        frutas2.add(new Organica("Fresa",2.8,0.1,0.06));
        Venta ventas2 = new Venta(frutas2);
        ventas2.mostrarTotales();
    }
}
