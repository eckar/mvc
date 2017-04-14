package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.semillero;
import controlador.semilleroDAO;

@ManagedBean
@RequestScoped

public class semilleroBean {
    private semillero sem = new semillero();

    public semillero getSem() {
        return sem;
    }

    public void setSem(semillero sem) {
        this.sem = sem;
    }
    
    public void crear() throws Exception{
        semilleroDAO dao;
        try{
            dao = new semilleroDAO();
            dao.crear(sem);
        }
        catch(Exception ex){
            throw ex;
        }
    }       
}
