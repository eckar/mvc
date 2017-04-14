package controlador;

import java.sql.PreparedStatement;
import modelo.hojacvlac;

public class hojacvlacDAO extends DAO{
    public void crear(hojacvlac hoj) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into tb_hojacvlac (numero, nombre_apellido,"
                + "n_documento, registro_cvlac, fecha_ing, fecha_rev, grupo_func, actividad, codigo_rol)"
                + "values (?,?,?,?,?,?,?,?)");
            st.setInt(1, hoj.getNumero());
            st.setString(2, hoj.getNombre());
            st.setString(3, hoj.getDocumento());
            st.setString(4, hoj.getRegistro());
            st.setDate(5, hoj.getFechaIng());
            st.setDate(6, hoj.getFechaRet());
            st.setString(7, hoj.getGrupo());
            st.setString(8, hoj.getActividad());
          }
        catch(Exception ex){
            throw ex;
        }
        finally{
            this.Cerrar();
        }
    }
}
