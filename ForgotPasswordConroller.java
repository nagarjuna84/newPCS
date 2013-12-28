/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;

/**
 *
 * @author Nagarjun Reddy
 */
public class ForgotPasswordConroller {
    @SuppressWarnings("empty-statement")
    public static String forgot(String username, String email)throws Exception
    {
        Connection conn;;
        conn=(Connection) DataBaseConnection.dbConnection();
	
	Statement stmt;
        stmt = (Statement) conn.createStatement();
	String sql;
        sql = "SELECT * FROM registrations WHERE user_name='"+username+"' AND emai_id='"+email+"'";
        ResultSet rs;
        rs = (ResultSet) stmt.executeQuery(sql);
        String passw=null;
        while(rs.next())
        {
            passw=rs.getString("password");
        }
        System.out.println("Test pass="+passw);
        return passw;
        
    }
    
}
