import java.util.Scanner;
public class Ejercicio2 {    
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Introduce un número entero: ");
        int numero = myObj.nextInt();

        int digitos = numeroDigitos(numero);
        System.out.println("El número tiene " + digitos + " cifras");

    }

    public static int numeroDigitos(int numero){
        int cifras = 0;
        while (numero != 0){
            numero /= 10;
            cifras++;
        }
        return cifras;
    }
    
}
