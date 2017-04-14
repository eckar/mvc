package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.convocatoria;
import controlador.convocatoriaDAO;

@ManagedBean
@RequestScoped

public class convocatoriaBean {
    private convocatoria con = new convocatoria();

    public convocatoria getCon() {
        return con;
    }

    public void setCon(convocatoria con) {
        this.con = con;
    }
    
    public void crear() throws Exception{
        convocatoriaDAO dao;
        try{
            dao = new convocatoriaDAO();
            dao.crear(con);
        }
        catch(Exception ex){
            throw ex;
        }
    }    
}
