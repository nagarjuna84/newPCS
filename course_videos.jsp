
<%-- 
    Document   : play_video
    Created on : Oct 10, 2013, 3:05:51 PM
    Author     : Nagarjun Reddy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %>
<%@ page import="javax.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="#E6E6FA"><br><div>
            <table style="background-color: #333333">
        <tr></tr> 
        <tr><td align ="right" style="font-family: Calibri; font-size: 35px; color: #d14836;" width="40%"><b>PCS Video Lectures</b><th></td><td width="20%" align="middle"><button type="button" style=" border-color: #d14836; color: white; background-color: #d14836; font-family: Calibri;" onClick="window.location.href='courses.jsp'">HOME</button></td><td width="20%"  style="font-family: Calibri; font-size: 25px; color: #d14836;" width="20%"><form id="form1">
<INPUT TYPE="button" VALUE="Upload" style=" border-color: #d14836; color: white; background-color: #d14836; font-family: Calibri;" onClick="window.location.href='Upload.jsp'"/>
        </form></td><td width="20%" align ="middle"><button type="button" style=" border-color: #d14836; color: white; background-color: #d14836; font-family: Calibri;" onClick="window.location.href='index.jsp'">Sign Out</button></td></tr>        
    </table><br> <table><tr><td width="30%"></td></tr>   
    </tr><tr><td><br></td></tr>
<form action="Search" method="get">
    <tr><td align="middle"><input size ="100" type="text" name="search"> <input type="submit" value="Search" style=" border-color: #d14836; color: white; background-color: #d14836; font-family: Calibri;"></td></tr></table>
</form>
     <%
            String course=request.getParameter("course");
            HttpSession s3 = request.getSession(true);
            s3.setAttribute("course",course);
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/SE","root","root");
            String sql_stmt="select * from videos where course='"+course+"'";
            Statement stmt =con.createStatement();
            ResultSet rs=stmt.executeQuery(sql_stmt);
            int i=0;
            while (rs.next()) 
            {
        %>
            <table width="70%">       
        
             <br>
            
             
            
            <tr><td width="40%"></td>
            <td style="font-family: Calibri; font-size: 35px; color: #d14836; "> <a href='play_video.jsp?video=<%=rs.getString(1)%>'style="text-decoration: none"><%=rs.getString(1)%></td>
            </tr>
            <tr><td width="40%"></td><td  style="font-family: Calibri; color: #333; font-size: 20px;"><font size="4">Description: </font><font size="3"><%=rs.getString(2)%></font></td></tr>
            <tr><td width="40%"></td>
            <td  style="font-family: Calibri; font-size: 15px; color: #333;">Likes:    <%=rs.getString(3)%></td></tr><tr>
            <td width="40%"></td><td style="font-family: Calibri; font-size: 15px; color: #333;">UnLikes:  <%=rs.getString(4)%></td></tr><tr><td><br></td></tr>
                </table>
    
           <%
                     }
           %>
            
    </body>
</html>

