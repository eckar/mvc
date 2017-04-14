package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.observatorio;
import controlador.observatorioDAO;

@ManagedBean
@RequestScoped

public class observatorioBean {
    private observatorio obs = new observatorio();

    public observatorio getObs() {
        return obs;
    }

    public void setObs(observatorio obs) {
        this.obs = obs;
    }
    
    public void crear() throws Exception{
        observatorioDAO dao;
        try{
            dao = new observatorioDAO();
            dao.crear(obs);
        }
        catch(Exception ex){
            throw ex;
        }
    }       
}
