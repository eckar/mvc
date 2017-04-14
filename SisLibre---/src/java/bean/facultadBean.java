package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.facultad;
import controlador.facultadDAO;

@ManagedBean
@RequestScoped

public class facultadBean {
    private facultad fac = new facultad();

    public facultad getFac() {
        return fac;
    }

    public void setFac(facultad fac) {
        this.fac = fac;
    }
    public void crear() throws Exception{
        facultadDAO dao;
        try{
            dao = new facultadDAO();
            dao.crear(fac);
        }
        catch(Exception ex){
            throw ex;
        }
    } 
}
