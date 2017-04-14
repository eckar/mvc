package controlador;

import java.sql.PreparedStatement;
import modelo.revistas;

public class revistasDAO extends DAO{
    public void crear(revistas rev) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into tb_revistas (nombre_revista, estado_revista,categoria,"
                    + "bases_int, volumen, issn, institucion, codigo_grupo, codigo_tiporev)"
                + "values (?,?,?,?,?,?,?,?,?)");
            st.setString(1, rev.getNombre_revista());
            st.setString(2, rev.getEstado_revista());
            st.setString(3, rev.getCategoria());
            st.setString(4, rev.getBases_int());
            st.setString(5, rev.getVolumen());
            st.setString(6, rev.getIssn());
            st.setString(7, rev.getInstitucion());
            st.setInt(8, rev.getCodigo_grupo());
            st.setInt(9, rev.getCodigo_tiporev());
        }
        catch(Exception ex){
            throw ex;
        }
        finally{
            this.Cerrar();
        }
    }        
    
}
