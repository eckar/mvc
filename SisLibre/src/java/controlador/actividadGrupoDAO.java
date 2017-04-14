package controlador;

import modelo.actividadGrupo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class actividadGrupoDAO extends DAO {
    public void crear(actividadGrupo actividad) throws Exception{
        try{
          this.Conectar();
          PreparedStatement st = this.getCn().prepareStatement("insert into tb_actividadgrupo (codigo_actividad, nombre_actividad, descripcion, resultados, fecha, codigoGrupo) values (?,?,?,?,?,?)");
          st.setInt(1, actividad.getCodigo());
          st.setString(2, actividad.getNombre());
          st.setString(3, actividad.getDescripcion());
          st.setString(4, actividad.getResultados());
          st.setDate(5, actividad.getFecha());
          st.setInt(6, actividad.getCodigoGrupo());
          st.executeUpdate();
        }
        catch(Exception ex){
            throw ex;
        }
        finally{
            this.Cerrar();
        }
    }//Cierre del metodo crear
    
    public List<actividadGrupo> listar() throws Exception{
        List<actividadGrupo> lista;
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("select select codigo_actividad, nombre_actividad, descripcion, resultados, fecha, codigoGrupo from tb_actividadgrupo;");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                actividadGrupo act = new actividadGrupo();
                act.setCodigo(rs.getInt("codigo_actividad"));
                act.setNombre(rs.getString("nombre_actividad"));
                act.setDescripcion(rs.getString("descripcion"));
                act.setResultados(rs.getString("resultados"));
                act.setFecha(rs.getDate("fecha"));
                act.setCodigoGrupo(rs.getInt("codigoGrupo"));
                lista.add(act);
            }            
        }
        catch(Exception ex){
            throw ex;
        }
        finally{
            this.Cerrar();
        }
        return lista;
    }//Cierre del metodo listar
    
    public actividadGrupo buscarID(actividadGrupo actividad) throws Exception{
        actividadGrupo act = null;
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("select codigo_actividad, nombre_actividad, descripcion, resultados, fecha, codigoGrupo from tb_actividadgrupo"+
                    " where codigo_actividad = ?");
            st.setInt(1, actividad.getCodigo());
            rs = st.executeQuery();
            while(rs.next()){
                act = new actividadGrupo();
                act.setCodigo(rs.getInt("codigo_actividad"));
                act.setNombre(rs.getString("nombre_actividad"));
                act.setDescripcion(rs.getString("descripcion"));
                act.setResultados(rs.getString("resultados"));
                act.setFecha(rs.getDate("fecha"));
                act.setCodigoGrupo(rs.getInt("codigoGrupo"));
            }            
        }
        catch(Exception ex){
            throw ex;
        }
        finally{
            this.Cerrar();
        }
        return act;
    }//Cierre del metodo buscar
    
    public void modificar (actividadGrupo actividad) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("update tb_actividadgrupo set nombre_actividad = ?, descripcion = ?, resultados = ?, fecha = ?, codigoGrupo = ? "+
                    " where codigo_actividad = ?");
            st.setString(1, actividad.getNombre());
            st.setString(2, actividad.getDescripcion());
            st.setString(3, actividad.getResultados());
            st.setDate(4, actividad.getFecha());
            st.setInt(5, actividad.getCodigoGrupo());
            st.setInt(5, actividad.getCodigo());
            st.executeUpdate();
        }
        catch(Exception ex){
            throw ex;
        }
        finally{
            this.Cerrar();
        }
    }//Cierre del metodo modificar
    
    public void eliminar(actividadGrupo actividad) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("delete from tb_actividadgrupo where codigo_actividad = ?");
            st.setInt(1, actividad.getCodigo());
            st.executeUpdate();
        }
        catch (Exception ex){
            throw ex;
        }
        finally{
            this.Cerrar();
        }
        
    }//Cierre del Metodo eliminar
}
