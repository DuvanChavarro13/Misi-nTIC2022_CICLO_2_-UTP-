package co.edu.utp.misiontic2022.c2;

public class BecaUniversitaria {

    //Atributos
    private double monto;
    private double interes;
    private int tiempo;

    //Constructores 
    public BecaUniversitaria(){
        this.monto = 0; 
        this.interes = 0; 
        this.tiempo = 0; 
    }

    public BecaUniversitaria(int pTiempo, double pMonto, double pInteres){
        this.tiempo = pTiempo; 
        this.monto = pMonto; 
        this.interes = pInteres; 
    }

    //Metodos  
    public double calcularInteresSimple(){
        double interesSimple = this.monto * (this.interes/100) * this.tiempo;
        return Math.round(interesSimple);
    }

    public double calcularInteresCompuesto(){
        // x^y 
        // Math.pow(x,y)

        double interesCompuesto = monto * (Math.pow(1 + this.interes/100, this.tiempo) -1); 
        return Math.round(interesCompuesto);
    }

    public String compararInversion(){ 
         
        double diferencia = 0;
        //Calcular la diferencia 
        diferencia = this.calcularInteresCompuesto() - this.calcularInteresSimple();

        if(diferencia == 0){
            return "No se obtuvo diferencia enmtre las proyecciones, revisar los parámetros de entrada.";
        }else{
            return "La diferencia entre la proyección de interés compuesto e interés simple es: $" + diferencia;
        }
    }

    public String compararInversion(int pTiempo, double pMonto, double pInteres){
        
        //Cargamos en los atributos porque calcularInteresCompuesto y calcularInteresSimple trabajan sobre estos
        this.tiempo = pTiempo; 
        this.monto = pMonto; 
        this.interes = pInteres;

        return this.compararInversion();
    }

    public static void main(String[] args) {
        
        //Caso de prueba 1
        BecaUniversitaria becaUniversitaria = new BecaUniversitaria();
        System.out.println(becaUniversitaria.calcularInteresSimple()); 
        System.out.println(becaUniversitaria.calcularInteresCompuesto());        
        System.out.println(becaUniversitaria.compararInversion(60,13000,1.4));
        System.out.println(becaUniversitaria.calcularInteresSimple()); 
        System.out.println(becaUniversitaria.calcularInteresCompuesto()); 
        
        System.out.println();

        //Caso de prueba 2
        BecaUniversitaria becaUniversitaria2 = new BecaUniversitaria(48,10000,2);
        System.out.println(becaUniversitaria2.calcularInteresSimple()); 
        System.out.println(becaUniversitaria2.calcularInteresCompuesto());        
        System.out.println(becaUniversitaria2.compararInversion());

        System.out.println();

        //Caso de prueba 3
        BecaUniversitaria becaUniversitaria3 = new BecaUniversitaria();
        System.out.println(becaUniversitaria3.calcularInteresSimple()); 
        System.out.println(becaUniversitaria3.calcularInteresCompuesto());        
        System.out.println(becaUniversitaria3.compararInversion());
    }
}
