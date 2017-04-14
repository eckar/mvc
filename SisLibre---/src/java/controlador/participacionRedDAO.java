package controlador;

import java.sql.PreparedStatement;
import modelo.participacionRed;

public class participacionRedDAO extends DAO{
    public void crear(participacionRed par) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into tb_participacionred (codigo_red, nombre_red,"
                    + "codigo_grupo, codigo_integrante, codigo_programa, codigo_proyecto)"
                + "values (?,?,?,?,?,?)");
            st.setInt(1, par.getCodigo());
            st.setString(2, par.getNombre());
            st.setInt(3, par.getCodigoGrupo());
            st.setInt(4, par.getCodigoIntegrante());
            st.setInt(5, par.getCodigoPrograma());
            st.setInt(6, par.getCodigoProyecto());
        }
        catch(Exception ex){
            throw ex;
        }
        finally{
            this.Cerrar();
        }
    }        
}
