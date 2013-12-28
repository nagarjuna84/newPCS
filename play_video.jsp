<%-- 
    Document   : play_video
    Created on : Oct 10, 2013, 3:05:51 PM
    Author     : Nagarjun Reddy
--%>

<%@page import="com.sun.xml.internal.ws.message.saaj.SAAJHeader"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %>
<%@ page import="javax.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<INPUT TYPE="button" VALUE="Upload" style=" border-color: #d14836; color: white; background-color: #d14836; font-family: Calibri;" onClick="window.location.href='Upload.jsp'"/>
<td width="20%" align ="middle"><button type="button" style=" border-color: #d14836; color: white; background-color: #d14836; font-family: Calibri;" onClick="window.location.href='index.jsp'">Sign Out</button></td></tr>        
    </table><br> <table><tr><td width="30%"></td></tr>   
    </tr><tr><td><br></td></tr>
<form action="Search" method="get">
    </table>
</form>
            
        <%
            String video=request.getParameter("video");
            System.out.println("Video is: "+video);
            System.out.println(video);
            if(video!=null)
            {
            HttpSession s3 = request.getSession(true);
            s3.setAttribute("vname",video);
            }
            HttpSession s3 = request.getSession(true);
            video=(String)s3.getAttribute("vname");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/SE","root","root");
            String sql_stmt1="select * from videos where name='"+video+"';";
    Statement stmt1 =con.createStatement();
    ResultSet rs1=stmt1.executeQuery(sql_stmt1);
     while (rs1.next()) 
                   {
        %>  <br>
        <table align="center">
        <tr>
             
            <td align="center"><video width="400" height="240" controls><source src="<%=video%>.mp4" type="video/mp4" ></td>  
        </tr>
        <table>
        <table>
        <tr>
              <td width="42%"></td>
              <td><form action="Likes" method="get"><input type="submit" value="LIKE" style=" border-color: #d14836; color: white; background-color: #d14836; font-family: Calibri;"></form></td>
              <td width="5%"></td>
              <td><form action="UnLikes" method="get"><input type="submit" value="UnLIKE" style=" border-color: #d14836; color: white; background-color: #d14836; font-family: Calibri;"></form></td>
              <td width="10%"></td>
              <td><button type="button" style=" width: 130px; border-color: #d14836; color: white; background-color: #d14836; font-family: Calibri;" onClick="window.location.href='discussion_form.jsp'">DISCUSSION FORUM</button></td>
              <td width="45%"></td>
        </tr></table>
            <table>
          <tr> <td width="20%"></td><td style="font-family: Calibri; font-size: 35px; color: #d14836; "><%=video%></td><td width="10%"></td></tr>
            <tr><td width="20%"><td align="left" style="font-family: Calibri; color: #333; font-size: 20px;">Description:<%=rs1.getString(2)%></td></tr>
            <tr>
                <td width="20%"><td  style="font-family: Calibri; font-size: 15px; color: #333;">Likes:<%=rs1.getString(3)%></td>
            </tr>
            <tr>
                <td width="20%"><td  style="font-family: Calibri; font-size: 15px; color: #333;">UnLikes:<%=rs1.getString(4)%></td>
            </tr>
            <tr><td><br></td></tr>
            <tr>
             <%
                         }
             %>
                </table>
    <table>
       
            <tr ><td width="20"><h1 align="middle" style="font-family: Calibri; font-size: 35px; color: #d14836;" >Comments:</h1></td>
                <td><form name="f1" action="Update" method="get"><input align="left" type="text" name="comment" style="width: 350px;"><input type="submit" value="submit" style=" border-color: #d14836; color: white; background-color: #d14836; font-family: Calibri;"></td>
            <td bgcolor="#E6E6FA"><body onload="showDate()">
                <input id="txtDate" name="date" type="text"  style="width: 350px; border: none;" />
</body></form>
                    </td></tr>  
                    <%
    String sql_stmt="select * from comments where vname='"+video+"';";
    Statement stmt =con.createStatement();
    ResultSet rs=stmt.executeQuery(sql_stmt);
                    %><center><tr><td align="middle" style="font-family: Calibri; font-size: 35px; color: #d14836; " width="40%">Date</td><td align="middle" style="font-family: Calibri; font-size: 35px; color: #d14836;" width="40%">user name</td><td align="middle" style="font-family: Calibri; font-size: 35px; color: #d14836;" width="40%">comment</td></tr></center>
                    <%
    while (rs.next()) 
                   {
                    %>
    <center><tr>
             
                    <td align="middle" width="20%">
                    <%=rs.getString(1) %>    
                    </td>
                    <td align="middle" width="20%">
                    <%=rs.getString(2) %>    
                    </td>
                    <td align="middle" width="20%">
                    <%=rs.getString(4) %>    
                    </td>
                    <td width="20%">
            </tr>
            <%
                       }
    
        
            %>
            </table> 
            
           
            
    </body>
</html>
