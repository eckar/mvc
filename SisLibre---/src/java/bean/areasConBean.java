package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.areasConocimiento;
import controlador.areasConocimientoDAO;

@ManagedBean
@RequestScoped

public class areasConBean {
    private areasConocimiento areacon = new areasConocimiento();

    public areasConocimiento getAreacon() {
        return areacon;
    }

    public void setAreacon(areasConocimiento areacon) {
        this.areacon = areacon;
    }
    
    public void crear() throws Exception{
        areasConocimientoDAO dao;
        try{
            dao = new areasConocimientoDAO();
            dao.crear(areacon);
            
        }
        catch(Exception ex){
            throw ex;
        }
    }
}
