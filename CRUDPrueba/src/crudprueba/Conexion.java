/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crudprueba;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Gangster
 */
public class Conexion {
    public static final String URL="jdbc:mysql://localhost:3306/empleados";
    public static final String User="root";
    public static final String Pass="";
    
    public static Connection getConnection(){
        Connection connection = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, User, Pass);
        }
        catch (Exception c){
            System.out.println("c");
        }
        return connection;
    }
    
}
