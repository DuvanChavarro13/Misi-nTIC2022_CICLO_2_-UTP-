package co.edu.utp.misiontic2022.c2;

public class Fruta {
    
    //Atributos
    private static final int GRAMAJE_BASE_VENTA = 200;
    private String nombre; 
    private double precioBase; 
    protected int gramosVenta; 
    protected boolean importada = false;

    //Constructores 
    
    public Fruta(String pNombre, double pPrecio){ 
        this.nombre = pNombre;
        this.precioBase = pPrecio;
        this.gramosVenta = Fruta.GRAMAJE_BASE_VENTA;
    }    
    
    public Fruta(String pNombre, double pPrecio, int pGramosVenta){
        this(pNombre, pPrecio);
        this.gramosVenta = pGramosVenta < Fruta.GRAMAJE_BASE_VENTA ? Fruta.GRAMAJE_BASE_VENTA : pGramosVenta;
        /** 
        if (pGramosVenta < Fruta.GRAMAJE_BASE_VENTA){
            this.gramosVenta = Fruta.GRAMAJE_BASE_VENTA;
        }else{
            this.gramosVenta = pGramosVenta;
        }
        */
    }   
    
    public Fruta(String pNombre, double pPrecio, int pGramosVenta, boolean pImportada){
        this(pNombre, pPrecio, pGramosVenta);
        this.importada = pImportada;
    }    
    
    //Métodos
    public double calcularPrecio(){  
        double precioVenta = this.precioBase * this.gramosVenta;
        if (this.importada){
            precioVenta += precioVenta * 0.1;
        }
        return precioVenta;
    }

    //Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }
    
}
