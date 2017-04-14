package controlador;

import java.sql.PreparedStatement;
import modelo.estadoacademico;

public class estadoacademicoDAO extends DAO{
    public void crear(estadoacademico est) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into tb_estadoacad (codigo_estado,nombre_estado,"
                + "area_form, institucion_form) "
                + "values (?,?,?,?)");
            st.setInt(1, est.getCodigo());
            st.setString(2, est.getNombre());
            st.setString(3, est.getAreaform());
            st.setString(3, est.getInstitucion());
        }
        catch(Exception ex){
            throw ex;
        }
        finally{
            this.Cerrar();
        }   
    }//Cierre del metodo Crear
    
}
