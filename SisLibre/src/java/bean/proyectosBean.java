package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.proyectos;
import controlador.proyectosDAO;

@ManagedBean
@RequestScoped

public class proyectosBean {
    
    private proyectos proy = new proyectos();

    public proyectos getProy() {
        return proy;
    }

    public void setProy(proyectos proy) {
        this.proy = proy;
    }
    
    public void crear() throws Exception{
        proyectosDAO dao;
        try{
            dao = new proyectosDAO();
            dao.crear(proy);
        }
        catch(Exception ex){
            throw ex;
        }
    }   
}
