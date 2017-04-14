package modelo;

import java.sql.Date;

public class integrante {
    private int codigo;
    private String nombre;
    private String identificacion;
    private String nacionalidad;
    private String depto;
    private String ciudad;
    private Date fecha;
    private int edad;
    private String cargo;
    private String par;
    private int estado;
    private int codigoGrupo;
    private int codigoSemillero;
    private int codigoPrograma;
    private int tipoInt;
    private int proyecto;
    private int tipoJor;
    private int observ;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }
    
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }    
    
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getPar() {
        return par;
    }

    public void setPar(String par) {
        this.par = par;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getCodigoGrupo() {
        return codigoGrupo;
    }

    public void setCodigoGrupo(int codigoGrupo) {
        this.codigoGrupo = codigoGrupo;
    }

    public int getCodigoSemillero() {
        return codigoSemillero;
    }

    public void setCodigoSemillero(int codigoSemillero) {
        this.codigoSemillero = codigoSemillero;
    }

    public int getCodigoPrograma() {
        return codigoPrograma;
    }

    public void setCodigoPrograma(int codigoPrograma) {
        this.codigoPrograma = codigoPrograma;
    }

    public int getTipoInt() {
        return tipoInt;
    }

    public void setTipoInt(int tipoInt) {
        this.tipoInt = tipoInt;
    }

    public int getProyecto() {
        return proyecto;
    }

    public void setProyecto(int proyecto) {
        this.proyecto = proyecto;
    }

    public int getTipoJor() {
        return tipoJor;
    }

    public void setTipoJor(int tipoJor) {
        this.tipoJor = tipoJor;
    }

    public int getObserv() {
        return observ;
    }

    public void setObserv(int observ) {
        this.observ = observ;
    }
    
    
}
