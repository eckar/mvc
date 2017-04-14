package controlador;

import java.sql.PreparedStatement;
import modelo.hojacvlac;

public class hojacvlacDAO extends DAO{
    public void crear(hojacvlac hoj) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into tb_facultad (codigo_facultad, nombre_grupo,"
                + "fecha_creacion, codigo_areacon, codigo_linea, programa_nal, departamento, ciudad, lider_grupo, avalado,"
                + "estado, categoria, codigo_centro, pagina_web, correo, direccion, telefono)"
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setInt(1, hoj.getNumero());
            st.setString(2, hoj.getNombre());
            st.setString(3, hoj.getDocumento());
            st.setString(4, hoj.getRegistro());
            st.setDate(5, hoj.getFechaIng());
            st.setDate(6, hoj.getFechaRet());
            st.setString(7, hoj.getGrupo());
            st.setString(8, hoj.getActividad());
            st.setInt(9, hoj.getCodigo());
        }
        catch(Exception ex){
            throw ex;
        }
        finally{
            this.Cerrar();
        }
    }
}
