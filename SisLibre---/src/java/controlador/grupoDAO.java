package controlador;

import java.sql.PreparedStatement;
import modelo.grupo;

public class grupoDAO extends DAO{
    public void crear(grupo gru) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into tb_facultad (codigo_facultad, nombre_grupo,"
                + "fecha_creacion, codigo_areacon, codigo_linea, programa_nal, departamento, ciudad, lider_grupo, avalado,"
                + "estado, categoria, codigo_centro, pagina_web, correo, direccion, telefono)"
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setInt(1, gru.getCodigo());
            st.setString(2, gru.getNombre());
            st.setDate(3, gru.getFecha());
            st.setInt(4, gru.getCodigoArea());
            st.setInt(5, gru.getCodigoLinea());
            st.setString(6, gru.getPrograma());
            st.setString(7, gru.getDepartamento());
            st.setString(8, gru.getCiudad());
            st.setString(9, gru.getLider());
            st.setString(10, gru.getAvalado());
            st.setString(11, gru.getEstado());
            st.setString(12, gru.getCategoria());
            st.setInt(13, gru.getCodigoCentro());
            st.setString(14, gru.getPagina());
            st.setString(15, gru.getCorreo());
            st.setString(16, gru.getDireccion());
            st.setString(17, gru.getTelefono());
        }
        catch(Exception ex){
            throw ex;
        }
        finally{
            this.Cerrar();
        }
    }//Cierre de metodo Crear
}
