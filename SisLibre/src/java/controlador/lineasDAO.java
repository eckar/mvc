package controlador;

import java.sql.PreparedStatement;
import modelo.lineas;

public class lineasDAO extends DAO {
    public void crear(lineas lin) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into tb_libros (codigo_libro, titulo,"
                + "serie, coleccion, autores)"
                + "values (?,?,?,?,?)");
            st.setInt(1, lin.getCodigo());
            st.setString(2, lin.getNombre());
            st.setString(3, lin.getObjetivo());
            st.setInt(4, lin.getCodigoGrupo());
            st.setInt(5, lin.getCodigoArea());
        }
        catch(Exception ex){
            throw ex;
        }
        finally{
            this.Cerrar();
        }
    }
}
