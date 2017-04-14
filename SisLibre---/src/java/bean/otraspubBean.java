package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.otraspub;
import controlador.otraspubDAO;

@ManagedBean
@RequestScoped

public class otraspubBean {
    private otraspub otr = new otraspub();

    public otraspub getOtr() {
        return otr;
    }

    public void setOtr(otraspub otr) {
        this.otr = otr;
    }
    
    public void crear() throws Exception{
        otraspubDAO dao;
        try{
            dao = new otraspubDAO();
            dao.crear(otr);
        }
        catch(Exception ex){
            throw ex;
        }
    }       
}
