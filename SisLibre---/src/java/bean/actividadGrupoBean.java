package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.actividadGrupo;
import controlador.actividadGrupoDAO;

@ManagedBean
@RequestScoped

public class actividadGrupoBean {
    
    private actividadGrupo actividad = new actividadGrupo();

    public actividadGrupo getActividad() {
        return actividad;
    }

    public void setActividad(actividadGrupo actividad) {
        this.actividad = actividad;
    }
    
    public void crear() throws Exception{
        actividadGrupoDAO dao;
        try{
            dao = new actividadGrupoDAO();
            dao.crear(actividad);
        }
        catch(Exception ex){
            throw ex;
        }
    }
}
