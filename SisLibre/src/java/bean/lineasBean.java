package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.lineas;
import controlador.lineasDAO;

@ManagedBean
@RequestScoped

public class lineasBean {
    private lineas lin = new lineas();

    public lineas getLin() {
        return lin;
    }

    public void setLin(lineas lin) {
        this.lin = lin;
    }
    
    public void crear() throws Exception{
        lineasDAO dao;
        try{
            dao = new lineasDAO();
            dao.crear(lin);
        }
        catch(Exception ex){
            throw ex;
        }
    }   
}
