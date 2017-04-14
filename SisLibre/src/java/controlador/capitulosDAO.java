package controlador;

import modelo.capitulos;
import java.sql.PreparedStatement;

public class capitulosDAO extends DAO{
    public void crear(capitulos cap) throws Exception{
        try{
            this.Conectar();
                PreparedStatement st = this.getCn().prepareStatement("insert into tb_capitulos "
                    + "(titulo,autor,editorial,isbn_capitulo,ano,codigo_libro,codigo_grupo,codigo_proyecto) "
                    + "values (?,?,?,?,?,?,?,?)");
                st.setString(1, cap.getTitulo());
                st.setString(2, cap.getAutor());
                st.setString(3, cap.getEditorial());
                st.setString(4, cap.getIsbn());
                st.setInt(5, cap.getAno());
                st.setInt(6, cap.getCodLibro());
                st.setInt(7, cap.getCodGrupo());
                st.setInt(8, cap.getCodProyecto());
        }
        catch(Exception ex){
            throw ex;            
        }
        finally{
            this.Cerrar();
        }
    }
}
