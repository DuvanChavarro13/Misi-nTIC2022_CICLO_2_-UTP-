package co.edu.utp.misiontic2022.c2;

import java.util.*;

public class Directivo extends Empleado {
    private String categoría;

    private Empleado[] subordinados;
    private int numSubordinados;

    public Directivo(String nombre, int edad, double sueldoBruto, String categoría) {
        super(nombre, edad, sueldoBruto);
        this.categoría = categoría;
        
        subordinados = new Empleado[10];
        numSubordinados = 0;
    }

    @Override
    public String mostrar() {
        return super.mostrar() + ", categoria = " + categoria;
    }

    public void addSubordinado(Empleado empleado) throws Exception {
        if(numSubordinados == 10){
            throw new Exception("No hay mas vacantes!!")
        }
        subordinados[numSubordinados] = empleado;
        empleado.setJefe(this);
        numSubordinados++;
    }

    
}
