package modelo;

public class revistas {
    private String nombre_revista;
    private String estado_revista;
    private String categoria;
    private String bases_int;
    private String volumen;
    private String issn;
    private String institucion;
    private int codigo_grupo;
    private int codigo_tiporev;

    public String getNombre_revista() {
        return nombre_revista;
    }

    public void setNombre_revista(String nombre_revista) {
        this.nombre_revista = nombre_revista;
    }

    public String getEstado_revista() {
        return estado_revista;
    }

    public void setEstado_revista(String estado_revista) {
        this.estado_revista = estado_revista;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getBases_int() {
        return bases_int;
    }

    public void setBases_int(String bases_int) {
        this.bases_int = bases_int;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public int getCodigo_grupo() {
        return codigo_grupo;
    }

    public void setCodigo_grupo(int codigo_grupo) {
        this.codigo_grupo = codigo_grupo;
    }

    public int getCodigo_tiporev() {
        return codigo_tiporev;
    }

    public void setCodigo_tiporev(int codigo_tiporev) {
        this.codigo_tiporev = codigo_tiporev;
    }
    
    
}
