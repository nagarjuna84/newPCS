<%-- 
    Document   : search
    Created on : Sep 5, 2013, 11:54:10 AM
    Author     : Nagarjun Reddy
--%>
<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %>
<%@ page import="javax.*"%>
<%@ page import="java.util.ArrayList"%>
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
    <tr><td align="middle"><input size ="100" type="text" name="search"> <input type="submit" value="Search" style=" border-color: #d14836; color: white; background-color: #d14836; font-family: Calibri;"></td></tr></table>
</form>
            <table align="center">
            <%
    HttpSession s=request.getSession(true);
    ArrayList<String> arrlist = new ArrayList<String>(5);
    String search=s.getAttribute("search").toString();
    if(search.equals(""))
    {
        %><h1> Search Field can't Be Empty<h1><%
    }
    else
    {
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/SE","root","root");
    String sql_stmt="select name,description,likes,unlikes from videos";
    Statement stmt =con.createStatement();
    ResultSet rs=stmt.executeQuery(sql_stmt);
    while (rs.next()) 
            {
                String s1[]=rs.getString(2).split(" ");
                String s2[]=search.split(" ");
                for(int j=0;j<s2.length;j++)
                {
                    for(int i=0;i<s1.length;i++)
                    {
                        if(s1[i].equalsIgnoreCase(s2[j])||s2[j].equalsIgnoreCase(rs.getString(1)))
                        {
                            
                            if(arrlist.contains(rs.getString(1)))
                            {
                            }
                            else
                            {
                                System.out.println(rs.getString(1));
                                arrlist.add(rs.getString(1));
                            }
                            break;
                       }
                    }    
                }
           }
            %><%
            if(arrlist.isEmpty())
    {
        %><h1> NO Result Found<h1><%
    }
       else
       {
            for (String str : arrlist) {
                         System.out.println("string = " + str);
                         sql_stmt="select name,description,likes,unlikes from videos where name='"+str+"';";
                         rs=stmt.executeQuery(sql_stmt);
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
             }
                       }
       }
            %>
</table>
    
    </div></body>
</html>