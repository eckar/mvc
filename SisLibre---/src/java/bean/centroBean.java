package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.centro;
import controlador.centroDAO;

@ManagedBean
@RequestScoped

public class centroBean {
    private centro cen = new centro();

    public centro getCen() {
        return cen;
    }

    public void setCen(centro cen) {
        this.cen = cen;
    }
    public void crear() throws Exception{
        centroDAO dao;
        try{
            dao = new centroDAO();
            dao.crear(cen);
        }
        catch(Exception ex){
            throw ex;
        }
    }
}
