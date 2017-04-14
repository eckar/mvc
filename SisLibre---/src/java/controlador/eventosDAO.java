package controlador;

import java.sql.PreparedStatement;
import modelo.eventos;

public class eventosDAO extends DAO{
    public void crear(eventos evt) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into tb_eventos (codigo_evento, nombre_evento, codigo_tipo,"
                    + "fecha, n_nacionales, n_inter, nombre_inst, horario, lugar_evento, pais_evento, codigo_programa, codigo_grupo) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setInt(1, evt.getCodigo());
            st.setString(2, evt.getNombre());
            st.setInt(3, evt.getCodigoTipo());
            st.setDate(4, evt.getFecha());
            st.setInt(5, evt.getNacionales());
            st.setInt(6, evt.getInter());
            st.setString(7, evt.getNombre_inst());
            st.setString(8, evt.getHorario());
            st.setString(9, evt.getLugar());
            st.setString(10, evt.getPais());
            st.setInt(11, evt.getCodigoPrograma());
            st.setInt(12, evt.getCodigoGrupo());
        }
        catch(Exception ex){
            throw ex;
        }
        finally{
            this.Cerrar();
        }          
    }//Cierre de metodo Crear
}
