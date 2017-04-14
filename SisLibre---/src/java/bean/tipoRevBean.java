package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.tipoRev;
import controlador.tipoRevDAO;

@ManagedBean    
@RequestScoped

public class tipoRevBean {
    private tipoRev trev = new tipoRev();

    public tipoRev getTrev() {
        return trev;
    }

    public void setTrev(tipoRev trev) {
        this.trev = trev;
    }
    public void crear() throws Exception{
        tipoRevDAO dao;
        try{
            dao = new tipoRevDAO();
            dao.crear(trev);
        }
        catch(Exception ex){
            throw ex;
        }
    }
    
}
