package co.edu.utp.misiontic2022.c2;

public class Organica extends Verdura{
    //Atributos
    private static final double DESCUENTO_NACIONALES_BASE = 0.05;
    private static final int GRAMAJE_MINIMO_DESCUENTO_NACIONAL = 250;
    private static final double SUBSIDIO_BASE = 0.12;
    private double descuentoNacionales; //El porcentaje de descuento llega por parámetro
    private double subsidio; //Por parámetro


    //Constructores
    
    public Organica(String pNombre, double pPrecio){
        super(pNombre, pPrecio);
        this.descuentoNacionales = Organica.DESCUENTO_NACIONALES_BASE;
        this.subsidio = Organica.SUBSIDIO_BASE;
    }    
    
    public Organica(String pNombre, double pPrecio, int pGramosVenta){  
        super(pNombre, pPrecio);
        super.gramosVenta = pGramosVenta; // Orgánicos-> no lo limitamos
    }    
    
    public Organica(String pNombre, double pPrecio, double pDescuentoNacionales){ 
        super(pNombre, pPrecio);
        this.descuentoNacionales = pDescuentoNacionales;
    }    
    
    public Organica(String pNombre, double pPrecio, double pDescuentoNacionales, double pSubsidio){
        this(pNombre, pPrecio, pDescuentoNacionales);
        this.subsidio = pSubsidio;
    }    
    
    public Organica(String pNombre, double pPrecio, double pDescuentoNacionales, double pSubsidio, int pGramosVenta, boolean pImportada){

        this(pNombre, pPrecio, pDescuentoNacionales, pSubsidio);
        super.gramosVenta = pGramosVenta;
        super.importada = pImportada;

    }
 
    //Métodos
    public double calcularPrecio(){  

        //Precio de venta original (incluye impuesto si es importada)
        double precioVenta = super.calcularPrecio();

        //Agregar el subsidio (cargoque cubre el consumidor por las pérdidas al ser orgánico)
        double precioOrganica = precioVenta + (precioVenta * this.subsidio);
        
        //Revisar si podemos aplicar descuento: cuando se cumplen las dos siguientes condiciones
        //1 Si es nacional
        //2 La compra supera gramaje de compra para descuento

        if(!super.importada && super.gramosVenta >= Organica.GRAMAJE_MINIMO_DESCUENTO_NACIONAL){
            precioOrganica -= precioVenta * this.descuentoNacionales;
        }
        return precioOrganica;
    }   
    
}
