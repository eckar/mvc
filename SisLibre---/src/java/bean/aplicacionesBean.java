package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.aplicaciones;
import controlador.aplicacionesDAO;

@ManagedBean
@RequestScoped

public class aplicacionesBean {
    private aplicaciones app = new aplicaciones();

    public aplicaciones getApp() {
        return app;
    }

    public void setApp(aplicaciones app) {
        this.app = app;
    }
    
    public void crear() throws Exception{
        aplicacionesDAO dao;
        try{
            dao = new aplicacionesDAO();
            dao.crear(app);
        }
        catch(Exception ex){
            throw ex;
        }
    }
    
}
