/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Nagarjun Reddy
 */
public class DataBaseConnection {
    public static java.sql.Connection dbConnection() throws ClassNotFoundException, SQLException
    {
        
        java.sql.Connection conn;
	String url;
        url = "jdbc:mysql://localhost:3306/SE_STANDALONE";
        Class.forName("com.mysql.jdbc.Driver");
        conn = (java.sql.Connection) DriverManager.getConnection(url,"root","root");
        return conn;
    }
    public static java.sql.Connection dbConnection1() throws ClassNotFoundException, SQLException
    {
        
        java.sql.Connection conn;
	String url;
        url = "jdbc:mysql://localhost:3306/SE";
        Class.forName("com.mysql.jdbc.Driver");
        conn = (java.sql.Connection) DriverManager.getConnection(url,"root","root");
        return conn;
    }
    
}
