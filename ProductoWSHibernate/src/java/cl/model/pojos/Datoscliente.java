package cl.model.pojos;
// Generated 16/08/2016 03:48:15 PM by Hibernate Tools 3.6.0



/**
 * Datoscliente generated by hbm2java
 */
public class Datoscliente  implements java.io.Serializable {


     private int identificacion;
     private String nombres;
     private String apellidos;
     private int edad;

    public Datoscliente() {
    }

    public Datoscliente(int identificacion, String nombres, String apellidos, int edad) {
       this.identificacion = identificacion;
       this.nombres = nombres;
       this.apellidos = apellidos;
       this.edad = edad;
    }
   
    public int getIdentificacion() {
        return this.identificacion;
    }
    
    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public int getEdad() {
        return this.edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }




}


