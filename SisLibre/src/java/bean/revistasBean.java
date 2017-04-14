package bean;

import controlador.programaAcadDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.revistas;
import controlador.revistasDAO;

@ManagedBean
@RequestScoped

public class revistasBean {
    private revistas rev = new revistas();

    public revistas getRev() {
        return rev;
    }

    public void setRev(revistas rev) {
        this.rev = rev;
    }
    
    public void crear() throws Exception{
        revistasDAO dao;
        try{
            dao = new revistasDAO();
            dao.crear(rev);
        }
        catch(Exception ex){
            throw ex;
        }
    }      
}
