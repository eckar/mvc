package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.programaAcad;
import controlador.programaAcadDAO;

@ManagedBean
@RequestScoped

public class programaAcadBean {
    private programaAcad pro = new programaAcad();

    public programaAcad getPro() {
        return pro;
    }

    public void setPro(programaAcad pro) {
        this.pro = pro;
    }
    
    public void crear() throws Exception{
        programaAcadDAO dao;
        try{
            dao = new programaAcadDAO();
            dao.crear(pro);
        }
        catch(Exception ex){
            throw ex;
        }
    }               
}
