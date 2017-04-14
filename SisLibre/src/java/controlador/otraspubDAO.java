package controlador;

import java.sql.PreparedStatement;
import modelo.otraspub;

public class otraspubDAO extends DAO{
    public void crear(otraspub otr) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into tb_otraspub (codigo, descripcion)"
                + "values (?,?)");
            st.setInt(1, otr.getCodigo());
            st.setString(2, otr.getDescripcion());
        }
        catch(Exception ex){
            throw ex;
        }
        finally{
            this.Cerrar();
        }
    }    
}
