package co.edu.utp.misiontic2020.c2;
import java.util.*;

public class PromedioAjustadoNotas {

    //Declaracion de variables
    private double promedio;
    private int peorNota;
    private String codigo;
    private int notas [] = new int[5];

    public void pedirDatos(){
        //Pedir el primer dato al estudiante (codigo)
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba el código del estudiante: ");
        codigo = sc.nextLine();
        
        //Pedir notas
        for(int i = 0; i < notas.length; i++) {
            System.out.println("Escriba la nota #"+(i+1)+": ");
            notas[i] = sc.nextInt();
        }
    }
    
    public void imprimirDatos(){
        
        //Imprimir las notas
        System.out.println("Las notas son: ");
        for (int i = 0; i < notas.length; i++) {
            System.out.println("Nota #" + (i+1) +": " + notas[i]);
        }
        
        //Imprimir el promedio del estudiante
        System.out.println("El promedio del estudiante " + codigo + " es: " + promedio); 
    }

    public void eliminarNota(){
        int indexPeorNota = 0;
        for (int i = 0; i < notas.length; i++) {
            if(notas[i] < notas[indexPeorNota])
                indexPeorNota = i;
        }
        notas[indexPeorNota] = 0;
    
    }

    public void sacarPromedio(){
        double suma = 0;
        for (double nota : notas){
            suma += nota;
        }
        promedio = (suma / 4) / 20;
        promedio = Math.round(promedio*100.0)/100.0;
    }

    public static void main(String[] args) {
        PromedioAjustadoNotas estudiante = new PromedioAjustadoNotas();
        estudiante.pedirDatos();
        estudiante.eliminarNota();
        estudiante.sacarPromedio();
        estudiante.imprimirDatos();
    }
}
