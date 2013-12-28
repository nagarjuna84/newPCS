package MSIT;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Nagarjun Reddy
 */
@WebServlet(name = "Upload", urlPatterns = {"/Upload"})
public class Upload extends HttpServlet {

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
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        System.out.println("request: "+request);
        if (!isMultipart) 
        {
            System.out.println("File Not Uploaded");
        } 
        else 
        {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List items = null;
            try {
                items = upload.parseRequest(request);        
            } 
            catch (FileUploadException ex) {
                Logger.getLogger(Upload.class.getName()).log(Level.SEVERE, null, ex);
            }
            String name[] = new String[2];
            String des = null;
            int i=0;
            Iterator itr = items.iterator();
            while (itr.hasNext()) 
            {
                FileItem item = (FileItem) itr.next();
                if (item.isFormField()){
                String name1 = item.getFieldName();
                System.out.println("name1: "+name1);
                name[i] = item.getString();
                i++;
                System.out.println("value: "+name);
                String value1 = item.getFieldName();
                System.out.println("name2: "+value1);
                des = item.getString();
                System.out.println("value: "+des);
                } else {       
                String itemName = item.getName();
                Random generator = new Random();
                int r = Math.abs(generator.nextInt());

                String reg = "[.*]";
                String replacingtext = "";
                System.out.println("Text before replacing is:-" + itemName);
                Pattern pattern = Pattern.compile(reg);
                Matcher matcher = pattern.matcher(itemName);
                StringBuffer buffer = new StringBuffer();

                while (matcher.find()) 
                {
                    matcher.appendReplacement(buffer, replacingtext);
                }
                int IndexOf = itemName.indexOf("."); 
                String domainName = itemName.substring(IndexOf);
                System.out.println("domainName: "+domainName);

                String finalimage = name[0]+domainName;
                System.out.println("Final Image==="+finalimage);

                File savedFile = new File("C:/Users/Nagarjun Reddy/Desktop/PCS/web/"+finalimage);
                String url = "jdbc:mysql://localhost:3306/SE";
                String driver = "com.mysql.jdbc.Driver";
                    try {
                        Class.forName(driver);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Upload.class.getName()).log(Level.SEVERE, null, ex);
                    }
                Connection con = null;
                    try {
                        con = DriverManager.getConnection(url,"root","root");
                    } catch (SQLException ex) {
                        Logger.getLogger(Upload.class.getName()).log(Level.SEVERE, null, ex);
                    }
                PreparedStatement pst = null;
                    try {
                        pst = con.prepareStatement("Insert into videos values(?,?,?,?,?)");
                    } catch (SQLException ex) {
                        Logger.getLogger(Upload.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        pst.setString(1, name[0]);
                    } catch (SQLException ex) {
                        Logger.getLogger(Upload.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        pst.setString(2, des);
                    } catch (SQLException ex) {
                        Logger.getLogger(Upload.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        pst.setInt(3, 0);
                    } catch (SQLException ex) {
                        Logger.getLogger(Upload.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        pst.setInt(4, 0);
                    } catch (SQLException ex) {
                        Logger.getLogger(Upload.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        pst.setString(5, "N/A");
                    } catch (SQLException ex) {
                        Logger.getLogger(Upload.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        pst.executeUpdate();
                    } catch (SQLException ex) {
                        Logger.getLogger(Upload.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        item.write(savedFile);
                    } catch (Exception ex) {
                        Logger.getLogger(Upload.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        
        response.sendRedirect("courses.jsp");
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
