package controlador;

import modelo.actividadGrupo;
import java.sql.PreparedStatement;

public class actividadGrupoDAO extends DAO {
    public void crear(actividadGrupo actividad) throws Exception{
        try{
          this.Conectar();
          PreparedStatement st = this.getCn().prepareStatement("insert into tb_actividadgrupo (codigo_actividad, nombre_actividad, descripcion, resultados, fecha, codigo_grupo) values (?,?,?,?,?,?)");
          st.setInt(1, actividad.getCodigo());
          st.setString(2, actividad.getNombre());
          st.setString(3, actividad.getDescripcion());
          st.setString(4, actividad.getResultados());
          st.setDate(5, actividad.getFecha());
          st.setInt(6, actividad.getCodigo_grupo());
          st.executeUpdate();
        }
        catch(Exception ex){
            throw ex;
        }
        finally{
            this.Cerrar();
        }
    }
    
}
