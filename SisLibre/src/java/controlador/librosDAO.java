package controlador;

import java.sql.PreparedStatement;
import modelo.libros;

public class librosDAO extends DAO {
        public void crear(libros lib) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into tb_libros (codigo_libro, titulo,"
                + "serie, coleccion, autores, isbn, ano, editorial, edicion, categoria, tipo_libro, codigo_grupo, codigo_proyecto)"
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setInt(1, lib.getCodigo());
            st.setString(2, lib.getTiitulo());
            st.setString(3, lib.getSerie());
            st.setString(4, lib.getColeccion());
            st.setString(5, lib.getAutores());
            st.setString(6, lib.getIsbn());
            st.setInt(7, lib.getAno());
            st.setString(8, lib.getEditorial());
            st.setString(9, lib.getEdicion());
            st.setString(10, lib.getCategoria());
            st.setString(11, lib.getTipoLibro());
            st.setInt(12, lib.getCodigoGrupo());
            st.setInt(13, lib.getCodigoProyecto());
        }
        catch(Exception ex){
            throw ex;
        }
        finally{
            this.Cerrar();
        }
    }
}
