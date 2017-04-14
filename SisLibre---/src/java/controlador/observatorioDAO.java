package controlador;

import java.sql.PreparedStatement;
import modelo.observatorio;

public class observatorioDAO extends DAO{
    public void crear(observatorio obs) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into tb_observatorio (codigo_observ, nombre_observ,"
                + "codigo_centro, codigo_grupo, codigo_proyecto)"
                + "values (?,?,?,?,?)");
            st.setInt(1, obs.getCodigo());
            st.setString(2, obs.getNombre());
            st.setInt(3, obs.getCodigoCentro());
            st.setInt(4, obs.getCodigoGrupo());
            st.setInt(5, obs.getCodigoProyecto());
        }
        catch(Exception ex){
            throw ex;
        }
        finally{
            this.Cerrar();
        }
    }
}
