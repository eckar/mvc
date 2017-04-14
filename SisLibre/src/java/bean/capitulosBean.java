package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.capitulos;
import controlador.capitulosDAO;

@ManagedBean
@RequestScoped

public class capitulosBean {
        private capitulos cap = new capitulos();

    public capitulos getCap() {
        return cap;
    }

    public void setCap(capitulos cap) {
        this.cap = cap;
    }
    public void crear() throws Exception{
        capitulosDAO dao;
        try{
            dao = new capitulosDAO();
            dao.crear(cap);
        }
        catch(Exception ex){
            throw ex;
        }
    }    
}
