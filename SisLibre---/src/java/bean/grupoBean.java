package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.grupo;
import controlador.grupoDAO;

@ManagedBean
@RequestScoped

public class grupoBean {
    private grupo gru = new grupo();

    public grupo getGru() {
        return gru;
    }

    public void setGru(grupo gru) {
        this.gru = gru;
    }
    
     public void crear() throws Exception{
        grupoDAO dao;
        try{
            dao = new grupoDAO();
            dao.crear(gru);
        }
        catch(Exception ex){
            throw ex;
        }
    } 
}
