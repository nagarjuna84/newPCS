<%@page import="java.sql.DriverManager"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page import="java.io.*"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body bgcolor="#E6E6FA"><div>
            <table style="background-color: #333333">
        <tr><td align ="right" style="font-family: Calibri; font-size: 35px; color: #d14836;" width="40%"><b>PCS Video Lectures</b><th></td><td width="20%" align="middle"><button type="button" style=" border-color: #d14836; color: white; background-color: #d14836; font-family: Calibri;" onClick="window.location.href='courses.jsp'">HOME</button></td><td width="20%"  style="font-family: Calibri; font-size: 25px; color: #d14836;" width="20%">

<!--<input type="file" id="fname" size="50" accept="video/*">-->
        </td><td width="20%" align ="middle"><button type="button" style=" border-color: #d14836; color: white; background-color: #d14836; font-family: Calibri;" onClick="window.location.href='index.jsp'">Sign Out</button></td></tr>        
    </table><br> <table><tr><td width="30%"></td></tr>   
    </tr><tr><td><br></td></tr></div>
<!--<form action="Search" method="get">
    <tr><td align="middle"><input size ="100" type="text" name="search"> <input type="submit" value="Search" style=" border-color: #d14836; color: white; background-color: #d14836; font-family: Calibri;"></td></tr></table>
</form>-->

<FORM enctype="multipart/form-data" method="POST" action="Upload">
                                    Video name: <INPUT TYPE="text" NAME="name" value=""/><br/>
                                    Description: <INPUT TYPE="text" NAME="des" value=""/><br/><br><br>
                                    <br><br><br/>
                                    File:	<INPUT TYPE="file" NAME="file" class="button"/>
                                    <INPUT TYPE="submit" VALUE="Upload" class="button" onclick="loadXMLDoc()"/>
                              </FORM>
    
    </body>
</html>