package co.edu.utp.misiontic2022.c2;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "BIENVENIDO AL SISTEMA DE NOTAS!" );

        //Probar la clase Nota 
        Nota nota1 = new Nota();
        Nota nota2 = new Nota(77);
        Nota nota3 = new Nota(3.8); 

        nota1.mostrarNota();
        nota2.mostrarNota();
        nota3.mostrarNota();
    }
}
