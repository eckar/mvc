package controlador;

import java.sql.PreparedStatement;
import modelo.integrante;

public class integranteDAO extends DAO {
    public void crear(integrante inte) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into tb_integrante (codigo_int, nombre_int,"
                + "identificacion, nacionalidad, depto_nac, ciudad_nac, fecha_nac, edad, cargo, par_evaluador, estado_acad,"
                + "codigo_grupo, codigo_semillero, codigo_programa, codigo_tipo_int, codigo_proyecto, codigo_tipo_jor, codigo_observ)"
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setInt(1, inte.getCodigo());
            st.setString(2, inte.getNombre());
            st.setString(3, inte.getIdentificacion());
            st.setString(4, inte.getNacionalidad());
            st.setString(5, inte.getDepto());
            st.setString(6, inte.getCiudad());
            st.setDate(7, inte.getFecha());
            st.setInt(8, inte.getEdad());
            st.setString(9, inte.getCargo());
            st.setString(10, inte.getPar());
            st.setInt(11, inte.getCodigoEstado());
            st.setInt(12, inte.getCodigoGrupo());
            st.setInt(13, inte.getCodigoSemillero());
            st.setInt(14, inte.getCodigoPrograma());
            st.setInt(15, inte.getCodigoTipoInt());
            st.setInt(16, inte.getCodigoProyecto());
            st.setInt(17, inte.getCodigoTipoJor());
            st.setInt(18, inte.getCodigoObserv());            
        }
        catch(Exception ex){
            throw ex;
        }
        finally{
            this.Cerrar();
        }
    }
}
