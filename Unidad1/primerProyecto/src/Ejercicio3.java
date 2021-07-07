import java.util.Scanner;
public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Por favor ingrese un número entero: ");
        int numero = myObj.nextInt();
        var potencias = potenciaDosYTres(numero);
        System.out.println("El doble y el triple del número ingresado es: "+ potencias[0] + ", "+ potencias[1]);
    }
    
    public static int[] potenciaDosYTres(int numero) {
        int[]resultado = new int[2];
        int potencia2 = numero*numero; 
        int potencia3 = numero*numero*numero;
        resultado[0] = potencia2;
        resultado[1] = potencia3;
        return resultado;
    }
}
