//Esta clase es parte de los envolventes 
// -> Donde vamos a alojar la información -> No deben tener nada de lógica. 
// Los objetos de esta clase sirven como transporte para traer o llevar información a la base de datos. 

//NOTA: El value objetc (VO), se debe tener antes del data access object (DAO)
// -> Debe tener molde, para luego construir los objetos 

package model.vo;

public class Lider {

    //Atributos --> Columnas de la tabla que representa la misma entidad 
    
    //Clases envolventes para las primitivas -> que hacen referencia a los atributos 
    
    //Columnas seleccionables
    private Integer idLider;
    private String nombre;
    private String primerApellido;
    private String segundoApellido; 
    private Integer salario;
    private Double clasificacion;  

    public Lider(){
        
    }

    public Lider(Integer idLider, String nombre){
        this.idLider = idLider;
        this.nombre = nombre;
    }

    //Getter y Setters 

    public Integer getIdLider() {
        return idLider;
    }

    public void setIdLider(Integer idLider) {
        this.idLider = idLider;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    public Double getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Double clasificacion) {
        this.clasificacion = clasificacion;
    }
    
    

}
