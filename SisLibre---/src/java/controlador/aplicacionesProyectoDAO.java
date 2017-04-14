package controlador;

import modelo.aplicacionesProyecto;
import java.sql.PreparedStatement;

public class aplicacionesProyectoDAO extends DAO{
    public void crear (aplicacionesProyecto aplicaciones) throws Exception{
        try{
          this.Conectar();
          PreparedStatement st = this.getCn().prepareStatement("insert into tb_approyecto (codigo_proyecto, codigo_aplicacion) values (?,?)");
          st.setInt(1, aplicaciones.getCodigo());
          st.setInt(2, aplicaciones.getCodigo_proyecto());
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
