package controlador;

import java.sql.PreparedStatement;
import modelo.proyectos;

public class proyectosDAO extends DAO{
    public void crear(proyectos pry) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into tb_proyectos (codigo_proyecto, nombre_proyecto, descripcion, "
                    + "impacto_proyecto, duracion_proyecto, estado, fecha_inicio, fecha_fin, autor_proyecto, referencia_bib, entidad_fin,"
                    + "observaciones, codigo_grupo, codigo_area, codigo_linea, recursos_fin)"
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setInt(1, pry.getCodigo());
            st.setString(2, pry.getNombre());
            st.setString(3, pry.getDescripcion());
            st.setString(4, pry.getImpacto());
            st.setString(5, pry.getDuracion());
            st.setString(6, pry.getEstado());
            st.setDate(7, pry.getFechaInicio());
            st.setDate(8, pry.getFechaFin());
            st.setString(9, pry.getAutor());
            st.setString(10, pry.getReferencia());
            st.setString(11, pry.getEntidad());
            st.setString(12, pry.getObservaciones());
            st.setInt(13, pry.getCodigoGrupo());
            st.setInt(14, pry.getCodigoArea());
            st.setInt(15, pry.getCodigoLinea());
            st.setDouble(16, pry.getRecursos());
        }
        catch(Exception ex){
            throw ex;
        }
        finally{
            this.Cerrar();
        }
    }        

}
