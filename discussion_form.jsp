<%-- 
    Document   : discussion_form
    Created on : Oct 25, 2013, 8:41:38 AM
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
        <script language="javascript"
         type="text/javascript">
             function showDate() {
               document.getElementById("txtDate").value = Date();}
    </script>
    </head>
    <body bgcolor="#E6E6FA"><br><div>
            <table style="background-color: #333333">
        <tr></tr> 
        <tr><td align ="right" style="font-family: Calibri; font-size: 35px; color: #d14836;" width="40%"><b>PCS Video Lectures</b><th></td><td width="20%" align="middle"><button type="button" style=" border-color: #d14836; color: white; background-color: #d14836; font-family: Calibri;" onClick="window.location.href='courses.jsp'">HOME</button></td><td width="20%"  style="font-family: Calibri; font-size: 25px; color: #d14836;" width="20%"><form id="form1">
<td width="20%" align ="middle"><button type="button" style=" border-color: #d14836; color: white; background-color: #d14836; font-family: Calibri;" onClick="window.location.href='index.jsp'">Sign Out</button></td></tr>        
    </table><br> <table><tr><td width="30%"></td></tr>   
    </tr><tr><td><br></td></tr>
<form action="Search" method="get">
    <tr><td align="middle"><input size ="100" type="text" name="search"> <input type="submit" value="Search" style=" border-color: #d14836; color: white; background-color: #d14836; font-family: Calibri;"></td></tr></table>
</form>
            <table align="center">
            <%
                HttpSession s3 = request.getSession(true);
                String video=(String)s3.getAttribute("vname");
            %>
           </table>
    <table align="center">
        <tr>
             
            <td align="center"><video width="400" height="240" controls><source src="<%=video%>.mp4" type="video/mp4" ></td>  
        </tr>
            <tr><h1 align="middle" style="font-family: Calibri; font-size: 35px; color: #d14836;" ><%=video%> Discussion Form</h1></td></tr>
            <tr><td width="80%"></td><td><form name="f1" action="UpdateForm" method="get"></td><td><body onload="showDate()"><input id="txtDate" name="date" type="text"  style="width: 350px; border: none;"/></body></td></tr>  
            
              </table>
    <table>
              
        <tr><td width="40%"></td> <td style="font-family: Calibri; font-size: 20px; color: #d14836;">Your Response:</td></tr>
         
        </table>
    <table>
        <tr>  <td width=260px></td>              
                         <td >
                             <form>
                                 
                                    <textarea cols="50" rows="5" style="width: 790px;height:100px;"type="text" name="response" ></textarea></td></tr><tr><td width="20%"></td><td><input style=" width: 50px; border-color: #d14836; color: white; background-color: #d14836; font-family: Calibri;" type="submit" value="submit">
                             </form>
                         </td> 
        </tr>
        <%
                    
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/SE","root","root");
    String sql_stmt="select * from form where vname='"+video+"';";
    Statement stmt =con.createStatement();
    ResultSet rs=stmt.executeQuery(sql_stmt);
                       %>
                    <%
    while (rs.next()) 
                   {
                    %>
    
                <tr>
                    <td style="width:100px;"></td>
                    <td style="font-family: Calibri; font-size: 20px; color: #d14836;width:200px"><%=rs.getString(1) %></td>
                </tr>
    </table>
                <table cellpadding="0" cellspacing="0">
                <tr>                     
                    <td width="500"height="100"> 
                    <td  bgcolor="white" width="1500" height="100"style="vertical-align: top; border:1px solid black; font-family: Calibri; font-size: 15px; color: black; "><%=rs.getString(2) %></td>
                        <td width="500"height="100">                 
                </tr>
            <%
                       }
    
        
            %>           
</table>

             
                
    </body>
     
</html>

