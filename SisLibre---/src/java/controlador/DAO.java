package controlador;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
    private Connection cn; 

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
    
    public void Conectar() throws Exception{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:33067/sislibre?user=root&password=");
        }
        catch(Exception ex){
            throw ex;
        }
    }//Metodo de Conexion a la BD
    
    public void Cerrar() throws Exception{
        try{
            if(cn != null){
                if(cn.isClosed() == false){
                    cn.close();
                }
            }
        }
        catch(Exception ex){
            throw ex;
        }
    }//Metodo de Cierre de la BD
    

}
