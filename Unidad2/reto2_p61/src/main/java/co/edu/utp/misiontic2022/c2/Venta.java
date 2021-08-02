package co.edu.utp.misiontic2022.c2;

import java.util.*;

public class Venta {
    
    //Atributos
    
    private double totalFrutas;
    private double totalFrutasOrganicas;
    private double totalFrutasConvencionales;
    private ArrayList<Fruta> listaFrutas = new ArrayList<Fruta>();
    private int frutaObsequio = -1;

    //Constructor 

    public Venta(ArrayList<Fruta> pListaFrutas){
        this.listaFrutas = pListaFrutas;
        this.totalFrutas = 0;
        this.totalFrutasOrganicas = 0;
        this.totalFrutasConvencionales = 0;
        this.frutaObsequio = -1;
    }
    
    //Requerimiento principal -> Realizar los cálculos de la venta o pedido
    public void mostrarTotales(){

        int numOrganicas = 0;
        int numConvencionales = 0;

        for (int i = 0; i < this.listaFrutas.size(); i++){
            if(this.listaFrutas.get(i) instanceof Convencional){
                numConvencionales++;
                this.totalFrutasConvencionales += this.listaFrutas.get(i).calcularPrecio();
            
            }else if(this.listaFrutas.get(i) instanceof Organica){
                numOrganicas++;
                this.totalFrutasOrganicas += this.listaFrutas.get(i).calcularPrecio();

                if(this.frutaObsequio == -1){
                    this.frutaObsequio = i;
                }else{
                    if(this.listaFrutas.get(this.frutaObsequio).calcularPrecio() < this.listaFrutas.get(i).calcularPrecio()){
                        this.frutaObsequio = i;
                    }
                }
            }else if(this.listaFrutas.get(i) instanceof Fruta){
                this.totalFrutas += this.listaFrutas.get(i).calcularPrecio();
            }
        }
        
        //Cálculo valor total de la compra
        double totalCompra = this.totalFrutas + this.totalFrutasConvencionales + this.totalFrutasOrganicas;
        
        //Primera parte de la salida
        System.out.println("Valor frutas cultivo convencional = " + this.totalFrutasConvencionales);
        System.out.println("Valor frutas cultivo orgánico = "+ this.totalFrutasOrganicas);
        
        //Condiciones para reportar obsequio
            //1) Mayor número de productos orgánicos
            //2) Por lo menos un obsequio cargado en los atributos del pedido después de revisión del listado
            if(numOrganicas > numConvencionales){
                String nombreObsequio = listaFrutas.get(this.frutaObsequio).getNombre();
                double descuento = listaFrutas.get(this.frutaObsequio).calcularPrecio() * 0.5;
                //Se descuenta a la totalCompra, la mitad del precio del item con descuento
                totalCompra -= descuento;
                
                //Descontar el 50% del producto orgánico de mayor valor
                System.out.println("Se han descontado " + descuento + " en el ítem " + nombreObsequio + " tipo orgánico");
            }   
            
        //Parte final
        System.out.println("Valor total compra = " + (totalFrutas + totalCompra));
    }


}
