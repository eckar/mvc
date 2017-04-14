package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.articulos;
import controlador.articulosDAO;

@ManagedBean
@RequestScoped

public class articulosBean {
    
    private articulos art = new articulos();

    public articulos getArt() {
        return art;
    }

    public void setArt(articulos art) {
        this.art = art;
    }

    public void crear() throws Exception{
        articulosDAO dao;
        try{
            dao = new articulosDAO();
            dao.crear(art);
        }
        catch(Exception ex){
            throw ex;
        }
    }
}
