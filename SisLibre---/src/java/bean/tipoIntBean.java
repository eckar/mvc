package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.tipoInt;
import controlador.tipoIntDAO;

@ManagedBean
@RequestScoped

public class tipoIntBean {
    private tipoInt tip = new tipoInt();

    public tipoInt getTip() {
        return tip;
    }

    public void setTip(tipoInt tip) {
        this.tip = tip;
    }
    public void crear() throws Exception{
        tipoIntDAO dao;
        try{
            dao = new tipoIntDAO();
            dao.crear(tip);
        }
        catch(Exception ex){
            throw ex;
        }
    }       

}
