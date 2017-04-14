package controlador;

import java.sql.PreparedStatement;
import modelo.tipoJor;

public class tipoJorDAO extends DAO{
    public void crear(tipoJor tjor) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into tb_tipojor (codigo_jornada, nombre_jornada)"
                + "values (?,?)");
            st.setInt(1, tjor.getCodigo());
            st.setString(2, tjor.getNombre());
        }
        catch(Exception ex){
            throw ex;
        }
        finally{
            this.Cerrar();
        }
    }      
}
