package co.edu.utp.misiontic2020.c2;

import java.util.*;
public class Ejercicio1 {

    //Algoritmo: Número de la suerte (OBJETIVO)
    //1) Solicitar al usuario la fecha en formato String
    //2) Extraer los pedazos que corresponden al mes, dia y año. (split)
    //3) Cada pedazo conventirlo en un valor numérico 
    //4) Sumar los pedazos y almacenarlos
    //5) De la sumatoria extraer las cifras
    //6) Sumar las cifras y retornar el número de la suerte
    //TRADUCIR A JAVA!! 

    //Sección de funciones o métodos
    public static int obtenerNumeroSuerte(String fecha){
        int numeroSuerte = 0; 

        //Extraer cada pedazo al String
        String [] arregloFecha = fecha.split("/",3);
        //12/03/2000

        int valorDia = Integer.parseInt(arregloFecha[0]); 
        int valorMes = Integer.parseInt(arregloFecha[1]);
        int valorAño = Integer.parseInt(arregloFecha[2]);
 
        int sumatoriaPartesFecha = valorDia + valorMes + valorAño;
        //Ahora de la sumatoria extraer las cifras
        /*
        while (sumatoriaPartesFecha > 0) {
            numeroSuerte += sumatoriaPartesFecha % 10; 
            sumatoriaPartesFecha = (sumatoriaPartesFecha / 10);
        }
        */
        String sumatoriaCadena = Integer.toString(sumatoriaPartesFecha);
        for (int i = 0; i < sumatoriaCadena.length(); i++){
            numeroSuerte = numeroSuerte + Character.getNumericValue(sumatoriaCadena.charAt(i));
            //System.out.println("numero de la suerte: " + numeroSuerte);
        }
        
        return numeroSuerte;
    }

    //Interacción////////////
    public static void saludo(){
        System.out.println("App Número Suerte!!");
    }

    public static String leerFecha(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresar la fecha DD/MM/AAAA: ");
        return sc.nextLine();
    }

    public static void reportarNumeroSuerte(int numeroSuerte){
        System.out.println("El número de la suerte es: " + numeroSuerte);
    }

    public static void main(String[] args) {
        
        saludo();
        reportarNumeroSuerte(obtenerNumeroSuerte(leerFecha()));
    }
    
}
