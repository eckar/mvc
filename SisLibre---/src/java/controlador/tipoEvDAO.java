package controlador;

import java.sql.PreparedStatement;
import modelo.tipoEv;

public class tipoEvDAO extends DAO{
    public void crear(tipoEv tev) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into tb_tipoev (codigo_tipo, nombre_tipo)"
                + "values (?,?)");
            st.setInt(1, tev.getCodigo());
            st.setString(2, tev.getNombre());
        }
        catch(Exception ex){
            throw ex;
        }
        finally{
            this.Cerrar();
        }
    }      
    
}
