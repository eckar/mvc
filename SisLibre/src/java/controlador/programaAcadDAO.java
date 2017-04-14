package controlador;

import java.sql.PreparedStatement;
import modelo.programaAcad;

public class programaAcadDAO extends DAO{
    public void crear(programaAcad pro) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into tb_programaacad (codigo_programa, nombre_programa,"
                    + "codigo_facultad)"
                + "values (?,?,?)");
            st.setInt(1, pro.getCodigo());
            st.setString(2, pro.getNombre());
            st.setInt(3, pro.getCodigoFacultad());            
        }
        catch(Exception ex){
            throw ex;
        }
        finally{
            this.Cerrar();
        }
    }        
}
