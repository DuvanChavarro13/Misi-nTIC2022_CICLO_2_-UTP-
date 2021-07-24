package co.edu.utp.misiontic2022.c2;

public class Empleado extends Persona{
    private double sueldoBruto;

    private Directivo jefe;

    public Empleado(String nombre, int edad, double sueldoBruto) {
        super(nombre, edad);
        this.sueldoBruto = sueldoBruto;
    }

    @Override
    public String mostrar() {
        return super.mostrar() + ", sueldo = " + this.sueldoBruto;
    }

    public void setJefe(Directivo jefe) {
        this.jefe = jefe;
    }

    
}
