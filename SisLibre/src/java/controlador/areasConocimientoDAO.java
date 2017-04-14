package controlador;

import modelo.areasConocimiento;
import java.sql.PreparedStatement;

public class areasConocimientoDAO extends DAO{
    public void crear(areasConocimiento area) throws Exception{
        try{
          this.Conectar();
          PreparedStatement st = this.getCn().prepareStatement("insert into tb_areacon (codigo_area, nombre_area) values (?,?)");
          st.setInt(1, area.getCodigo());
          st.setString(2, area.getNombre());
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
