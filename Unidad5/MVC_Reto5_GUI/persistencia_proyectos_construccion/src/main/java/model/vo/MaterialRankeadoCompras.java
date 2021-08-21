package model.vo;

public class MaterialRankeadoCompras {

    //Atributos 
    private String nombreMaterial;
    private String importado;
    private Integer numeroCompras;


    //Constructor
    public MaterialRankeadoCompras(){
    
    }

    public MaterialRankeadoCompras(String nombreMaterial, String importado, Integer numeroCompras){
        this.nombreMaterial = nombreMaterial;
        this.importado = importado;
        this.numeroCompras = numeroCompras;
    }

    //Getters y Setters
    public String getNombreMaterial() {
        return nombreMaterial;
    }


    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }


    public String getImportado() {
        return importado;
    }


    public void setImportado(String importado) {
        this.importado = importado;
    }


    public Integer getNumeroCompras() {
        return numeroCompras;
    }


    public void setNumeroCompras(Integer numeroCompras) {
        this.numeroCompras = numeroCompras;
    }

}
