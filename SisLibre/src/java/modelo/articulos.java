package modelo;

public class articulos {
    
    private String titulo;
    private String nombre_revista;
    private int codigo_revista;
    private String autor_articulo;
    private int ano;
    private String pagina_web;
    private int codigo_grupo;
    private int codigo_proyecto;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombre_revista() {
        return nombre_revista;
    }

    public void setNombre_revista(String nombre_revista) {
        this.nombre_revista = nombre_revista;
    }

    public int getCodigo_revista() {
        return codigo_revista;
    }

    public void setCodigo_revista(int codigo_revista) {
        this.codigo_revista = codigo_revista;
    }

    public String getAutor_articulo() {
        return autor_articulo;
    }

    public void setAutor_articulo(String autor_articulo) {
        this.autor_articulo = autor_articulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getPagina_web() {
        return pagina_web;
    }

    public void setPagina_web(String pagina_web) {
        this.pagina_web = pagina_web;
    }

    public int getCodigo_grupo() {
        return codigo_grupo;
    }

    public void setCodigo_grupo(int codigo_grupo) {
        this.codigo_grupo = codigo_grupo;
    }

    public int getCodigo_proyecto() {
        return codigo_proyecto;
    }

    public void setCodigo_proyecto(int codigo_proyecto) {
        this.codigo_proyecto = codigo_proyecto;
    }
    
    
}
