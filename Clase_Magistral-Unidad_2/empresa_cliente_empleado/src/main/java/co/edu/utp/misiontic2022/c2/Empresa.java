package co.edu.utp.misiontic2022.c2;

import java.util.*;

public class Empresa {
    //Atributos 
    private String nit; 
    private String nombre;

    private List<Empleado> empleados;
    private List<Cliente> clientes;

    //Constructores 
    public Empresa(){ 
        this("0000000000", "Sin crear");
    }

    public Empresa(String nit, String nombre){
        this.nit = nit;
        this.nombre = nombre;

        this.empleados = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    //Getters y Setters
    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
}
