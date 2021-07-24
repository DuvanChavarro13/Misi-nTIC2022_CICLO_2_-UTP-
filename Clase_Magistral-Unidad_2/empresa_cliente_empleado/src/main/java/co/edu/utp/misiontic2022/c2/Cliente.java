package co.edu.utp.misiontic2022.c2;

public class Cliente extends Persona{
    private String telefonoContacto;

    public Cliente(String nombre, int edad, String telefonoContacto) {
        super(nombre, edad);
        this.telefonoContacto = telefonoContacto;
    }

    @Override
    public String mostrar() {
        return super.mostrar() + ", telefono contacto=" + telefonoContacto;
    }

    

    
    
}
