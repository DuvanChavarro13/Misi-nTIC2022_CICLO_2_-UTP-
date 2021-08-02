package co.edu.utp.misiontic2022.c2;

public class Convencional extends Fruta {
    
    //Atributos
    private static final double RECARGO_CONVENCIONAL_BASE = 0.08;
    private double recargoConvencionales;
    private int gradoAditamientos = 1;

    //Constructores
    public Convencional(String pNombre, double pPrecio){
        super(pNombre, pPrecio);
        this.recargoConvencionales = Convencional.RECARGO_CONVENCIONAL_BASE;
    }    
    
    public Convencional(String pNombre, double pPrecio, double pRecargo){
        this(pNombre, pPrecio);
        this.recargoConvencionales = pRecargo;
    }    
    
    public Convencional(String pNombre, double pPrecio, double pRecargo, int pGradoAditamentos){
        this(pNombre, pPrecio, pRecargo);
        this.gradoAditamientos = pGradoAditamentos;

    }    
    
    public Convencional(String pNombre, double pPrecio, double pRecargo, int pGradoAditamentos, int pGramosVenta, boolean pImportada){
        this(pNombre, pPrecio, pRecargo, pGradoAditamentos);
        super.gramosVenta = pGramosVenta;
        super.importada = pImportada;

    }
    
    public Convencional(String pNombre, double pPrecio, int pGramosVenta, boolean pImportada){
        this(pNombre, pPrecio);
        super.gramosVenta = pGramosVenta;
        super.importada = pImportada;
    }
    
    //Métodos
    public double calcularPrecio(){
        //Precio de venta original para cualquier fruta
        double precioVenta = super.calcularPrecio();
       
        //Recargo por defecto, predefinido o viene por parámetro.
        double precioVentaConvencional = precioVenta + precioVenta * this.recargoConvencionales;
      
        //Aumento del precio en un 1% por el grado de aditamientos que se le indique
        precioVentaConvencional += precioVenta * (this.gradoAditamientos * 0.01);
        
        return precioVentaConvencional;
    } 
}
