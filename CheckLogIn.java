/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Nagarjun Reddy
 */
public class CheckLogIn {
    public int checklogin(String login, String password)throws Exception
    {   
        Connection conn=DataBaseConnection.dbConnection();
	Statement stmt;
        stmt = (Statement) conn.createStatement();
	String sql;
        sql = "SELECT * FROM registration";
        ResultSet rs;
  //      System.out.println("<-!->");
        rs = (ResultSet) stmt.executeQuery(sql);
        
        ArrayList db_username=new ArrayList();
        ArrayList db_password=new ArrayList();
        
        while(rs.next()){
            
            db_username.add(rs.getString("username"));
            db_password.add(rs.getString("password"));
            
        }
   
        if (db_username.contains(login)){
            //System.out.println("login found");
            int a= db_username.indexOf(login);
            //System.out.println(a);
            //System.out.println(db_password.get(a));
            if (db_password.get(a).equals(password))
            {
                System.out.println("Login Successful");
                return 0;
               
                
            }
            else{
                //password didn't match Username
                //JOptionPane.showMessageDialog(null,"Password didn't match with username");
                JOptionPane.showMessageDialog(null,"Paswsword doesn't match");
                return 3;
                }
        }
        else{
            //Username not found in database
            JOptionPane.showMessageDialog(null,"Username not found.");
            return 2;
             }
    }
    
}
