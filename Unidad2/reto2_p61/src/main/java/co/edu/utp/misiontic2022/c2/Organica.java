package co.edu.utp.misiontic2022.c2;

public class Organica extends Fruta{

    //Atributos
    private static final double DESCUENTO_NACIONALES_BASE = 0.05;
    private static final int GRAMAJE_MINIMO_DESCUENTO_NACIONAL = 250;
    private static final double SUBSIDIO_BASE = 0.12;
    private double descuentoNacionales;
    private double subsidio;


    //Constructores
    public Organica(String pNombre, double pPrecio){
        super(pNombre, pPrecio);
        this.descuentoNacionales = Organica.DESCUENTO_NACIONALES_BASE;
        this.subsidio = Organica.SUBSIDIO_BASE;
    }    
    
    public Organica(String pNombre, double pPrecio, int pGramosVenta){
        this(pNombre, pPrecio);
        super.gramosVenta = pGramosVenta;
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
        //Precio de venta original para cualquier fruta
        double precioVenta = super.calcularPrecio();

        //Condición 1: Se agrega el subsidio del 12%
        double precioVentaOrganica = precioVenta + (precioVenta * this.subsidio);

        //Condición 2: Si se aplica descuento si: 
            // -Es nacional
            // -Si cumple es mayor o igual al gramaje de compra minimo 
        if(!super.importada && super.gramosVenta >= Organica.GRAMAJE_MINIMO_DESCUENTO_NACIONAL){
            precioVentaOrganica -= precioVenta * this.descuentoNacionales; 
        }

        return precioVentaOrganica;
    }

}
