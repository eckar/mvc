package controlador;

import java.sql.PreparedStatement;
import modelo.tipoInt;

public class tipoIntDAO extends DAO {
    public void crear(tipoInt tip) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into tb_tipo_int (codigo_tipo, nombre_tipo)"
                + "values (?,?)");
            st.setInt(1, tip.getCodigo());
            st.setString(2, tip.getNombre());
        }
        catch(Exception ex){
            throw ex;
        }
        finally{
            this.Cerrar();
        }
    }      
}
