import java.util.Scanner;
public class Ejercicio4 {
    public static void main(String[] args) {
        aviso(); 
        var numero = capturaNumero(); 
        System.out.println("El valor en grados Farrenheit es: " + pasaGrados(numero));
    }

    public static float pasaGrados(float gc){
        var f = 32+(9*gc/5);
        return f;
    }

    public static float capturaNumero(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca grados centígrados: ");
        var numero = sc.nextFloat();
        return numero;
    }
    
    public static void aviso(){
        System.out.println("\nEste programa captura un valor en grados centígrados y los convierte a grados Farrenheit");
    }
    
}
