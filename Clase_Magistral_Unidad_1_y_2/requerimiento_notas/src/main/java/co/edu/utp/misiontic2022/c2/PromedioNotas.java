package co.edu.utp.misiontic2022.c2;

import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class PromedioNotas {

    /* 
    Paso a paso -> Algoritmo 
    1) Recoger la información: código del estudiante y las 5 notas 
    2) Identificar cual es la peor nota 
    3) Hallar el promedio ajustado (descastar la peor de las notas)
    4) Reportar el promedio
    */
    
    //Funciones que resuelven el problema -> Modularizado
    public static int obtenerPeorNota(int nota1, int nota2, int nota3, int nota4, int nota5){
        int peorNota; 

        peorNota = nota1; 
        if (peorNota < nota2){
            peorNota = nota2;
        }
        if (peorNota < nota3){
            peorNota = nota3;
        }
        if (peorNota < nota4){
            peorNota = nota4;
        }
        if (peorNota < nota5){
            peorNota = nota5;
        }
        return peorNota;
    }
    
    public static double calcularPromedioAjustado(int nota1, int nota2, int nota3, int nota4, int nota5){

        int peorNota = obtenerPeorNota(nota1, nota2, nota3, nota4, nota5);
        int sumatoria = 0;
        double promedioAjustado = 0;

        sumatoria = (nota1 + nota2 + nota3 + nota4 + nota5) - peorNota;
        promedioAjustado = (double)sumatoria/4;
        return promedioAjustado;
    }

    public static double convertirEscala5(double calificacion100){
        return (calificacion100/20);
    }

    public static void reportarPromedioAjustado(String codigo, double promedioAjustado){
        System.out.println("El promedio ajustado del estudiante " + codigo + " es: " + promedioAjustado);
    }
    //Seccion principal o punto de entrada para consumir estas funciones
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Ingrese el código del estudiante: ");
        String codigoEstudiante = sc.nextLine();

        System.out.print("Ingrese la nota 1: ");
        int nota1 = sc.nextInt();
        System.out.print("Ingrese la nota 2: ");
        int nota2 = sc.nextInt();
        System.out.print("Ingrese la nota 3: ");
        int nota3 = sc.nextInt();
        System.out.print("Ingrese la nota 4: ");
        int nota4 = sc.nextInt();
        System.out.print("Ingrese la nota 5: ");
        int nota5 = sc.nextInt();

        //Ejecutar las funciones 
        double promedioAjustado = convertirEscala5(calcularPromedioAjustado(nota1, nota2, nota3, nota4, nota5)) ;
        reportarPromedioAjustado(codigoEstudiante, Math.round(promedioAjustado));
    }

}
