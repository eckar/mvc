package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.libros;
import controlador.librosDAO;

@ManagedBean
@RequestScoped

public class librosBean {
    private libros lib = new libros();

    public libros getLib() {
        return lib;
    }

    public void setLib(libros lib) {
        this.lib = lib;
    }
    
    public void crear() throws Exception{
        librosDAO dao;
        try{
            dao = new librosDAO();
            dao.crear(lib);
        }
        catch(Exception ex){
            throw ex;
        }
    } 
}
