package controlador;

import java.sql.PreparedStatement;
import modelo.tipoRev;

public class tipoRevDAO extends DAO {
    public void crear(tipoRev trev) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into tb_tiporev (codigo_tipo, descripcion)"
                + "values (?,?)");
            st.setInt(1, trev.getCodigo());
            st.setString(2, trev.getNombre());
        }
        catch(Exception ex){
            throw ex;
        }
        finally{
            this.Cerrar();
        }
    }      
}
