
package crudprueba2;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {    
    public static final String URL="jdbc:mysql://localhost:3306/salario";
    public static final String User="root";
    public static final String Pass="";
    
    public static Connection getConnection(){
        Connection connection = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL,User,Pass);
            
        }catch (Exception e){
            System.out.println("e");
        }
        return connection;
    }
    
}

