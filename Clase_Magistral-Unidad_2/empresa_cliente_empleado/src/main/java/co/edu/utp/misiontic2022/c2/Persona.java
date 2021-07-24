package co.edu.utp.misiontic2022.c2;


public abstract class Persona {
    //Atributos
    private String nombre;
    private int edad; 


    //Construtores
    public Persona(){ 
        this.nombre = "No hay ningún nombre";
        this.edad = 0;
    }

    public Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    //Métodos
    public String mostrar(){
        return String.format("Nombre=%s, edad=%d", nombre, edad);
    }
}
