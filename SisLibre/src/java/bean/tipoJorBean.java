package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.tipoJor;
import controlador.tipoJorDAO;

@ManagedBean    
@RequestScoped

public class tipoJorBean {
    private tipoJor tjor = new tipoJor();

    public tipoJor getTev() {
        return tjor;
    }

    public void setTev(tipoJor tev) {
        this.tjor = tjor;
    }
    public void crear() throws Exception{
        tipoJorDAO dao;
        try{
            dao = new tipoJorDAO();
            dao.crear(tjor);
        }
        catch(Exception ex){
            throw ex;
        }
    }
}
