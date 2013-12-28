/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MSIT;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

/**
 *
 * @author Nagarjun Reddy
 */
@WebServlet(name = "Registration", urlPatterns = {"/Registration"})
public class Registration extends HttpServlet {

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
           System.out.println("in service");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Connection con = null;
        int val;
        String url = "jdbc:mysql://localhost:3306";
	String db = "SE";
	String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver);
        con = DriverManager.getConnection(url,"root","root");
        String str="CREATE DATABASE IF NOT EXISTS "+db;
        Statement stmt=con.createStatement();
        stmt.executeUpdate(str);
        str="use "+db;
        Statement stmt1=con.createStatement();
        stmt1.executeUpdate(str);
        try {
        String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String uname = request.getParameter("user");
            String pass = request.getParameter("pwd");
            String date =  request.getParameter("year")+"-"+request.getParameter("month")+"-"+request.getParameter("day"); 
            String gen = request.getParameter("gen");
            String mail = request.getParameter("mail");
            String add = request.getParameter("add");
            String que = request.getParameter("que");
            String ans = request.getParameter("ans");
       str="create table if not exists registration(firstname varchar(21) DEFAULT NULL,lastname varchar(21) DEFAULT NULL,username varchar(20) NOT NULL,password varchar(20) DEFAULT NULL,DOB date DEFAULT NULL,emailid varchar(25) DEFAULT NULL,gender varchar(6) DEFAULT NULL,address varchar(300) DEFAULT NULL,secret varchar(30) DEFAULT NULL,answer varchar(40) DEFAULT NULL,PRIMARY KEY(username))";
        Statement stmt3=con.createStatement();
        stmt3.executeUpdate(str);
        PreparedStatement pstmt=con.prepareStatement("select username from registration where username=?");
        pstmt.setString(1,uname);
        ResultSet rs=pstmt.executeQuery();
        
        if(rs.next())
        {
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Username already registered</title>");
                out.println("</head>");
                out.println("<body bgcolor=\'#E6E6FA\'>");
                out.println("<h1><center> Username already registered </center></h1>");
                out.println("<center><a href='Registration.html'><input type='button' value='Registration'></center</a>");
                out.println("</body>");
                out.println("</html>");
        }
        else                
        {
        
                PreparedStatement pst=con.prepareStatement("Insert into registration values(?,?,?,?,?,?,?,?,?,?)");
                pst.setString(1, fname);
                pst.setString(2, lname);
                pst.setString(3, uname);
                pst.setString(4, pass);
                pst.setString(5, date);
                pst.setString(6, mail);
                pst.setString(7, gen);
                pst.setString(8, add);
                pst.setString(9, que);
                pst.setString(10, ans);
                    pst.executeUpdate();
                    System.out.println("The records selected are:"); 
                    out.println("<html>");
                    out.println("<head>");            
                    out.println("</head>");
                    out.println("<body bgcolor=\'#E6E6FA\'>");
                    out.println("<h1><center>Registration Successfull</center></h1>");
                   response.sendRedirect("main.jsp");
                    out.println("</body>");
                    out.println("</html>");
         }
        }
                    catch(SQLException ex) {
                    ex.printStackTrace();
                      }
                    catch(Exception e)
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
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
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
