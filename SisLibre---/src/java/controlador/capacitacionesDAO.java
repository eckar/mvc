package controlador;

import java.sql.PreparedStatement;
import modelo.capacitaciones;

public class capacitacionesDAO extends DAO{
    public void crear(capacitaciones cap) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into tb_capacitacion (codigo_cap,nombre_cap,"
                    + "tipo_cap,fecha_cap,n_participantes,horario,duracion,modulos,profesor,modalidad,codigo_programa,codigo_grupo) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setInt(1, cap.getCodigo());
            st.setString(2, cap.getNombre());
            st.setString(3, cap.getTipo());
            st.setDate(4, cap.getFecha());
            st.setInt(5, cap.getParticipantes());
            st.setString(6, cap.getHorario());
            st.setString(7, cap.getDuracion());
            st.setString(8, cap.getModulos());
            st.setString(9, cap.getProfesor());
            st.setString(10, cap.getModalidad());
            st.setInt(11, cap.getCodPrograma());
            st.setInt(12, cap.getCodGrupo());
        }
        catch(Exception ex){
            throw ex;
        }
        finally{
            this.Cerrar();
        }
    }    
}
