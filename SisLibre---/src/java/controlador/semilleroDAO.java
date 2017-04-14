package controlador;

import java.sql.PreparedStatement;
import modelo.semillero;

public class semilleroDAO extends DAO{
    public void crear(semillero sem) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into tb_semillero (codigo_semillero, nombre_semillero,"
                    + "recurso_fin, codigo_programa, codigo_proyecto, codigo_grupo, codigo_centro)"
                + "values (?,?,?,?,?,?,?)");
            st.setInt(1, sem.getCodigo());
            st.setString(2, sem.getNombre());
            st.setDouble(3, sem.getRecurso());
            st.setInt(4, sem.getCodigoPrograma());
            st.setInt(5, sem.getCodigoProyecto());
            st.setInt(6, sem.getCodigoGrupo());
            st.setInt(7, sem.getCodigoCentro());            
        }
        catch(Exception ex){
            throw ex;
        }
        finally{
            this.Cerrar();
        }
    }        
}
