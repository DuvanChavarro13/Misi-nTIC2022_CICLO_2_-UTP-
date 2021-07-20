package co.edu.utp.misiontic2022.c2;

public class VentaProyecto {

    //Atributos 
    private int tiempo; 
    private double monto;
    private double interes; 

    //Constructores 
    public VentaProyecto(){
        this.tiempo = 0;
        this.monto = 0;
        this.interes = 0;
    }

    public VentaProyecto(int pTiempo, double pMonto, double pInteres){
        this.tiempo = pTiempo;
        this.monto = pMonto;
        this.interes = pInteres;
    }

    //Metodos
    public double calcularInteresSimple(){
        return Math.round(this.monto * (this.interes/100) * this.tiempo);
    }

    public double calcularInteresCompuesto(){
        return Math.round(this.monto * (Math.pow(1 + this.interes/100, this.tiempo) -1));
    }

    public String compararInversion(){
        double compararInversion = calcularInteresCompuesto() - calcularInteresSimple();

        if(compararInversion != 0){
            return "La diferencia entre la proyección de interés compuesto e interés simple es: $" + compararInversion;
        }else{
            return "No se obtuvo diferencia entre las proyecciones, revisar los parámetros de entrada.";
        }
         
    }
    public String compararInversion(int pTiempo, double pMonto, double pInteres){
        this.tiempo = pTiempo;
        this.monto = pMonto;
        this.interes = pInteres;

        return compararInversion();
    }

    //Sección principal: Instancias de la clase 

    public static void main(String[] args) {

        //Prueba 1
        VentaProyecto ventaConstruccion = new VentaProyecto();
        System.out.println(ventaConstruccion.calcularInteresSimple());
        System.out.println(ventaConstruccion.calcularInteresCompuesto());
        System.out.println(ventaConstruccion.compararInversion(36, 200000, 5.0));

        //Prueba 2
        VentaProyecto ventaConstruccion2 = new VentaProyecto(12, 150000, 2.0);
        System.out.println(ventaConstruccion2.calcularInteresSimple());
        System.out.println(ventaConstruccion2.calcularInteresCompuesto());
        System.out.println(ventaConstruccion2.compararInversion());

        //Prueba 3
        VentaProyecto ventaConstruccion3 = new VentaProyecto();
        System.out.println(ventaConstruccion3.calcularInteresSimple());
        System.out.println(ventaConstruccion3.calcularInteresCompuesto());
        System.out.println(ventaConstruccion3.compararInversion());
    }
    
}
