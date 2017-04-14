package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.actividadGrupo;
import controlador.actividadGrupoDAO;
import java.util.List;

@ManagedBean
@RequestScoped

public class actividadGrupoBean {
    
    private actividadGrupo actividad = new actividadGrupo();
    private List<actividadGrupo> lstactividadGrupo;

    public actividadGrupo getActividad() {
        return actividad;
    }

    public void setActividad(actividadGrupo actividad) {
        this.actividad = actividad;
    }
    
    public void listar() throws Exception{
        actividadGrupoDAO dao;
        try{
            dao = new actividadGrupoDAO();
            lstactividadGrupo = dao.listar();
        }
        catch (Exception ex){
            throw ex;
        }
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
    
    public void buscar() throws Exception{
        actividadGrupoDAO dao;
    }
    
    public void modificar() throws Exception{
        actividadGrupoDAO dao;
        try{
            dao = new actividadGrupoDAO();
            dao.modificar(actividad);
            this.listar();
        }
        catch(Exception ex){
            throw ex;
        }
    }
    
    public void eliminar() throws Exception{
        actividadGrupoDAO dao;
        try{
            dao = new actividadGrupoDAO();
            dao.eliminar(actividad);
            this.listar();
        }
        catch(Exception ex){
            throw ex;
        }
    }
}
