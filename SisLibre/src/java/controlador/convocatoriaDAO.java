package controlador;

import java.sql.PreparedStatement;
import modelo.convocatoria;

public class convocatoriaDAO extends DAO{
    public void crear(convocatoria con) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into tb_convocatoria (codigo_conv,nombre_conv,"
                + "estado, codigo_programa, codigo_integrante, codigo_grupo, codigo_proyecto) "
                + "values (?,?,?,?,?,?,?)");
            st.setInt(1, con.getCodigo());
            st.setString(2, con.getNombre());
            st.setString(3, con.getEstado());
            st.setInt(4, con.getCodigoPrograma());
            st.setInt(5, con.getCodigoIntegrante());
            st.setInt(6, con.getCodigoGrupo());
            st.setInt(7, con.getCodigoProyecto());
        }
        catch(Exception ex){
            throw ex;
        }
        finally{
            this.Cerrar();
        }   
    }//Cierre del metodo Crear
}
