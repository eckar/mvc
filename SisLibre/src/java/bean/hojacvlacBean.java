package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.hojacvlac;
import controlador.hojacvlacDAO;

@ManagedBean
@RequestScoped

public class hojacvlacBean {
    private hojacvlac hoj = new hojacvlac();

    public hojacvlac getHoj() {
        return hoj;
    }

    public void setHoj(hojacvlac hoj) {
        this.hoj = hoj;
    }
    
    public void crear() throws Exception{
        hojacvlacDAO dao;
        try{
            dao = new hojacvlacDAO();
            dao.crear(hoj);
        }
        catch(Exception ex){
            throw ex;
        }
    } 
}
