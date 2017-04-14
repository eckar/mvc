package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.estadoacademico;
import controlador.estadoacademicoDAO;

@ManagedBean
@RequestScoped

public class estadoacademicoBean {
    private estadoacademico est = new estadoacademico();

    public estadoacademico getEst() {
        return est;
    }

    public void setEst(estadoacademico est) {
        this.est = est;
    }
    
    public void crear() throws Exception{
        estadoacademicoDAO dao;
        try{
            dao = new estadoacademicoDAO();
            dao.crear(est);
        }
        catch(Exception ex){
            throw ex;
        }
    }  
}
