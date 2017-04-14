package modelo;

public class participacionRed {
    private int codigo;
    private String nombre;
    private int codigoGrupo;
    private int codigoIntegrante;
    private int codigoPrograma;
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

    public int getCodigoGrupo() {
        return codigoGrupo;
    }

    public void setCodigoGrupo(int codigoGrupo) {
        this.codigoGrupo = codigoGrupo;
    }

    public int getCodigoIntegrante() {
        return codigoIntegrante;
    }

    public void setCodigoIntegrante(int codigoIntegrante) {
        this.codigoIntegrante = codigoIntegrante;
    }

    public int getCodigoPrograma() {
        return codigoPrograma;
    }

    public void setCodigoPrograma(int codigoPrograma) {
        this.codigoPrograma = codigoPrograma;
    }

    public int getCodigoProyecto() {
        return codigoProyecto;
    }

    public void setCodigoProyecto(int codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
    }
}
