package controlador;

import modelo.aplicaciones;
import java.sql.PreparedStatement;

public class aplicacionesDAO extends DAO{
    public void crear(aplicaciones app) throws Exception{
        try{
          this.Conectar();
          PreparedStatement st = this.getCn().prepareStatement("insert into tb_aplicaciones(codigo, descripcion) values (?,?)");
          st.setInt(1, app.getCodigo());
          st.setString(2, app.getDescripcion());
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
