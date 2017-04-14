package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.integrante;
import controlador.integranteDAO;

@ManagedBean
@RequestScoped

public class integranteBean {
    private integrante inte = new integrante();

    public integrante getInte() {
        return inte;
    }

    public void setInte(integrante inte) {
        this.inte = inte;
    }
    
    public void crear() throws Exception{
        integranteDAO dao;
        try{
            dao = new integranteDAO();
            dao.crear(inte);
        }
        catch(Exception ex){
            throw ex;
        }
    } 

    
}
