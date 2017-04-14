package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.tipoEv;
import controlador.tipoEvDAO;

@ManagedBean
@RequestScoped

public class tipoevBean {
    private tipoEv tev = new tipoEv();

    public tipoEv getTev() {
        return tev;
    }

    public void setTev(tipoEv tev) {
        this.tev = tev;
    }
    
     public void crear() throws Exception{
        tipoEvDAO dao;
        try{
            dao = new tipoEvDAO();
            dao.crear(tev);
        }
        catch(Exception ex){
            throw ex;
        }
    }
    
}
