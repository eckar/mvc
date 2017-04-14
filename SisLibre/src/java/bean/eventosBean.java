package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.eventos;
import controlador.eventosDAO;

@ManagedBean
@RequestScoped

public class eventosBean {
    private eventos evt = new eventos();

    public eventos getEvt() {
        return evt;
    }

    public void setEvt(eventos evt) {
        this.evt = evt;
    }
    
    public void crear() throws Exception{
        eventosDAO dao;
        try{
            dao = new eventosDAO();
            dao.crear(evt);
        }
        catch(Exception ex){
            throw ex;
        }
    } 
}
