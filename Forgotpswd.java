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
@WebServlet(name = "Forgotpswd", urlPatterns = {"/Forgotpswd"})
public class Forgotpswd extends HttpServlet {

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
        String uname=request.getParameter("user");
        HttpSession s=request.getSession(true);
        s.setAttribute("Name",uname);
        String que=request.getParameter("que");
        String ans=request.getParameter("ans");
        System.out.println("servlet called");
        PrintWriter out = response.getWriter();
        String sql_stmt="";
        try 
	{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/SE","root","root");
        sql_stmt="select username,secret,answer from registration where username='"+uname+"' and secret='"+que+"' and answer='"+ans+"'";
        Statement stmt =con.createStatement();
        ResultSet rs=stmt.executeQuery(sql_stmt);
        if(rs.next())
        {
             response.sendRedirect("changepwd.jsp");
        }
        else
        {
            out.println("<html>");
             out.println("<head>");            
             out.println("</head>");
             out.println("<body bgcolor=\'#E6E6FA\'>");
             out.println("<center><h1>Entered Question and answer is wrong</h1></center>");
             out.println("<center><a href='fgtpassword.html'><input type='button' value='Re-Try'></a></center>");
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
