/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MSIT;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
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
@WebServlet(name = "Changepwd", urlPatterns = {"/Changepwd"})
public class Changepwd extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession s=request.getSession(true);
        String uname=(String)s.getAttribute("Name");
        String pwd=request.getParameter("pwd");
        String rpwd=request.getParameter("rpwd");
        System.out.println("servlet called");
        PrintWriter out = response.getWriter();
        String sql_stmt="";
        try 
	{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/SE","root","root");
        sql_stmt="update registration set password='"+pwd+"' where username='"+uname+"'";
        Statement stmt =con.createStatement();
        int n=stmt.executeUpdate(sql_stmt);
        if(n==1)
        {
              System.out.println("exicuted");
             out.println("<html>");
             out.println("<head>");            
             out.println("</head>");
             out.println("<body bgcolor='#E6E6FA'>");
             out.println("<table style='background-color: black'><tr></tr>"); 
             out.println("<tr><td style='font-family: Calibri; font-size: 35px; color: #d14836; ' width='80%'><b>PCS Video Lectures</b><th></td><td width='20%'></td></tr></table><br>");
             out.println("<center><h1>Your Password is sucessfully updated</h1></center>");
             out.println("<center><a href='index.jsp'><input type='button' value='Login'></a></center>");
             out.println("</body>");
             out.println("</html>");
        }
        else
        {
            out.println("<html>");
             out.println("<head>");            
             out.println("</head>");
             out.println("<body background=\'image/back5.jpg\'>");
             out.println("<center><h1>Your Password is not sucessfully updated</h1></center>");
             out.println("<center><a href='forgot.html'><input type='button' value='Re-Try'></a></center>");
             out.println("<center><a href='index.jsp'><input type='button' value='Login'></a></center>");
             out.println("</body>");
             out.println("</html>");
        }
        }catch(Exception e)
        {
            System.out.println(e);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
