package controlador;

import java.sql.PreparedStatement;
import modelo.centro;

public class centroDAO extends DAO{
    public void crear(centro cen) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into tb_centro (codigo,nombre_centro,"
                    + "departamento, ciudad, paginaweb, correo, codigo_director, codigo_facultad) "
                    + "values (?,?,?,?,?,?,?,?)");
            st.setInt(1, cen.getCodigo());
            st.setString(2, cen.getNombre());
            st.setString(3, cen.getDepartamento());
            st.setString(4, cen.getCiudad());
            st.setString(5, cen.getPagina());
            st.setString(6, cen.getCorreo());
            st.setInt(7, cen.getCodDirector());
            st.setInt(8, cen.getCodFacultad());    
        }
        catch(Exception ex){
            throw ex;
        }
        finally{
            this.Cerrar();
        }        
    }    
}
