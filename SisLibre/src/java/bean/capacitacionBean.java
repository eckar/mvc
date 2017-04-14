package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.capacitaciones;
import controlador.capacitacionesDAO;

@ManagedBean
@RequestScoped

public class capacitacionBean {
        private capacitaciones cap = new capacitaciones();

    public capacitaciones getCap() {
        return cap;
    }

    public void setCap(capacitaciones cap) {
        this.cap = cap;
    }
    public void crear() throws Exception{
        capacitacionesDAO dao;
        try{
            dao = new capacitacionesDAO();
            dao.crear(cap);
        }
        catch(Exception ex){
            throw ex;
        }
    }        
}
