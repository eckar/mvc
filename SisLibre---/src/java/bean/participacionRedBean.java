package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.participacionRed;
import controlador.participacionRedDAO;

@ManagedBean
@RequestScoped

public class participacionRedBean {
    private participacionRed par = new participacionRed();

    public participacionRed getPar() {
        return par;
    }

    public void setPar(participacionRed par) {
        this.par = par;
    }
    
    public void crear() throws Exception{
        participacionRedDAO dao;
        try{
            dao = new participacionRedDAO();
            dao.crear(par);
        }
        catch(Exception ex){
            throw ex;
        }
    }           
}
