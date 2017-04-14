package modelo;

import java.sql.PreparedStatement;

public class convocatoria {
    private int codigo;
    private String nombre;
    private String estado;
    private int codigoPrograma;
    private int codigoIntegrante;
    private int codigoGrupo;
    private int codigoProyecto;

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCodigoPrograma() {
        return codigoPrograma;
    }

    public void setCodigoPrograma(int codigoPrograma) {
        this.codigoPrograma = codigoPrograma;
    }

    public int getCodigoIntegrante() {
        return codigoIntegrante;
    }

    public void setCodigoIntegrante(int codigoIntegrante) {
        this.codigoIntegrante = codigoIntegrante;
    }

    public int getCodigoGrupo() {
        return codigoGrupo;
    }

    public void setCodigoGrupo(int codigoGrupo) {
        this.codigoGrupo = codigoGrupo;
    }

    public int getCodigoProyecto() {
        return codigoProyecto;
    }

    public void setCodigoProyecto(int codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
    }
    
    
    
}
