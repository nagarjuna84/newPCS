/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MSIT;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nagarjun Reddy
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String uname=request.getParameter("user");
        HttpSession s3 = request.getSession(true);
        s3.setAttribute("uname",uname);
        String pswd=request.getParameter("pwd");
        System.out.println("servlet called");
        PrintWriter out = response.getWriter();
        String pswd2="";
        String sql_stmt="";
        try 
	{
        String url = "jdbc:mysql://localhost:3306";
	String db = "SE";
	String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,"root","root");
        String str="CREATE DATABASE IF NOT EXISTS "+db;
        Statement stmt=con.createStatement();
        stmt.executeUpdate(str);
        str="use "+db;
        Statement stmt1=con.createStatement();
        stmt1.executeUpdate(str);
        str="create table if not exists registration(firstname varchar(21) DEFAULT NULL,lastname varchar(21) DEFAULT NULL,username varchar(20) NOT NULL,password varchar(20) DEFAULT NULL,DOB date DEFAULT NULL,emailid varchar(25) DEFAULT NULL,gender varchar(6) DEFAULT NULL,address varchar(300) DEFAULT NULL,secret varchar(30) DEFAULT NULL,answer varchar(40) DEFAULT NULL,PRIMARY KEY(username))";
        Statement stmt3=con.createStatement();
        stmt3.executeUpdate(str);
        sql_stmt="select password from registration where username="+"'"+uname+"'";
        Statement stmt2 =con.createStatement();
        ResultSet rs=stmt2.executeQuery(sql_stmt);
        while(rs.next())
        {
            pswd2=rs.getString(1);
            System.out.println(pswd2);
        }
        if(pswd.equals(pswd2))
        {
            System.out.println(pswd2);
            HttpSession s = request.getSession(true);
            s.setAttribute("Name",new String(uname));
            out.println("<html>");
            out.println("<h1><center>Login Successful</center></h1>");
            response.sendRedirect("courses.jsp");
            out.println("</body>");
            out.println("</html>");
        }
        else
        {
             out.println("<html>");
             out.println("<head>");
             out.println("<title><center>Login is fail retry</title>");
             out.println("</head>");
             out.println("body bgcolor='#E6E6FA'");
             out.println("<h1><center> Login is fail retry</center></h1>");
             out.println("<h1><center><td><a href=\'index.jsp\'><input type=\'button\' value=\'Re-Try\'></a></h1></td></center><h1>");
             out.println("</body>");
             response.sendRedirect("index.jsp");
             out.println("</html>");
             
        }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
