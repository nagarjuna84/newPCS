<%-- 
    Document   : courses
    Created on : Oct 24, 2013, 11:44:36 PM
    Author     : Nagarjun Reddy
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <script>
function displayResult()
{
var x=document.getElementById("fname").accept;
alert(x);
}
</script>
    </head>
    <body bgcolor="#E6E6FA"><br><div>
     <table style="background-color: #333333">
        <tr></tr> 
        <tr><td align ="right" style="font-family: Calibri; font-size: 35px; color: #d14836;" width="40%"><b>PCS Video Lectures</b><th></td><td width="20%" align="middle"><button type="button" style=" border-color: #d14836; color: white; background-color: #d14836; font-family: Calibri;" onClick="window.location.href='courses.jsp'">HOME</button></td><td width="20%"  style="font-family: Calibri; font-size: 25px; color: #d14836;" width="20%"><form id="form1">
<INPUT TYPE="button" VALUE="Upload" style=" border-color: #d14836; color: white; background-color: #d14836; font-family: Calibri;" onClick="window.location.href='Upload.jsp'"/>
</FORM>

        </td><td width="20%" align ="middle"><button type="button" style=" border-color: #d14836; color: white; background-color: #d14836; font-family: Calibri;" onClick="window.location.href='index.jsp'">Sign Out</button></td></tr>        
    </table><br> <table><tr><td width="30%"></td></tr>   
    </tr><tr><td><br></td></tr>
<form action="Search" method="get">
    <tr><td align="middle"><input size ="100"type="text" name="search"> <input type="submit" value="Search" style=" border-color: #d14836; color: white; background-color: #d14836; font-family: Calibri;"></td></tr></form></table>
    <br>
     <table align="center">
            <%
     
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/SE","root","root");
    String sql_stmt="select * from courses";
    Statement stmt =con.createStatement();
    ResultSet rs=stmt.executeQuery(sql_stmt);
    int i=0;
    while (rs.next()) 
            {    
                %>
            
            <tr>
                 <td width="25%"></td>
                 <td>
                     <a href='course_videos.jsp?course=<%=rs.getString(1)%>'><img src="<%=rs.getString(1)%>.jpg"   width="200" height="230"></a>
                 </td><td width="4%"></td>
                 <td align="justified" style="font-family: Calibri; color: #333; font-size: 20px;">
                     <%=rs.getString(2)%>
                 </td>
                  <td width="25%"></td>
             </tr> 
            <% 
            
        }
           
%>
</table>
    </div></body>
</html>

