package controlador;

import java.sql.PreparedStatement;
import modelo.facultad;

public class facultadDAO extends DAO{
    public void crear(facultad fac) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into tb_facultad (codigo_facultad, nombre_facultad)"
                + "values (?,?)");
            st.setInt(1, fac.getCodigo());
            st.setString(2, fac.getNombre());
        }
        catch(Exception ex){
            throw ex;
        }
        finally{
            this.Cerrar();
        }  
    }//Cierre de metodo Crear
}