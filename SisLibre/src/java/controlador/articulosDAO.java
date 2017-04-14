package controlador;

import modelo.articulos;
import java.sql.PreparedStatement;

public class articulosDAO extends DAO{
    public void crear(articulos art) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into tb_articulos (titulo, nombre_revista, codigo_revista, autor_articulo, ano, pagina_web, codigo_grupo, codigo_proyecto) values (?,?,?,?,?,?,?,?)");
            st.setString(1, art.getTitulo());
            st.setString(2, art.getNombre_revista());
            st.setInt(3, art.getCodigo_revista());
            st.setString(4, art.getAutor_articulo());
            st.setInt(5, art.getAno());
            st.setString(6, art.getPagina_web());
            st.setInt(7, art.getCodigo_grupo());
            st.setInt(8, art.getCodigo_proyecto());
            st.executeUpdate();
        }
        catch(Exception ex){
            throw ex;
        }
        finally{
            this.Cerrar();
        }
    }    
}
