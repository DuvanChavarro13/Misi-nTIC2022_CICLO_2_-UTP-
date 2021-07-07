import java.util.Scanner;
public class Ejercicio5 {
    public static void main(String[] args) {
        System.out.println("Este programa verifica si un número es par o impar");
        var numero = capturaNumero();
        var verificacion = verificacion(numero);
        System.out.println("El número ingresado: "+numero+" es "+verificacion);

    }
    
    public static int capturaNumero(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca un número entero: ");
        int numero = sc.nextInt();
        return numero;
    }

    public static String verificacion(int numero){
        var resultado = (numero%2 == 0) ? "par" : "impar";
        return resultado;
    }

}
