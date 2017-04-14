package bean;

import controlador.actividadGrupoDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.aplicacionesProyecto;
import controlador.aplicacionesProyectoDAO;

@ManagedBean
@RequestScoped

public class aplicacionesProyectoBean {
    
    private aplicacionesProyecto aplicaciones = new aplicacionesProyecto();

    public aplicacionesProyecto getAplicaciones() {
        return aplicaciones;
    }

    public void setAplicaciones(aplicacionesProyecto aplicaciones) {
        this.aplicaciones = aplicaciones;
    }
    public void crear() throws Exception{
        aplicacionesProyectoDAO dao;
        try{
            dao = new aplicacionesProyectoDAO();
            dao.crear(aplicaciones);
        }
        catch(Exception ex){
            throw ex;
        }
    }
}
