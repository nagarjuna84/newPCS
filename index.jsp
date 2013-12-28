<%-- 
    Document   : index
    Created on : Sep 4, 2013, 6:53:44 PM
    Author     : SivaRamaKrishnamRaju
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>   
<br>
    <table style="background-color:  #1C1C1C">
        <tr></tr> 
        <tr><td align="middle" style="font-family: Calibri; font-size: 35px; color: #d14836; " width="40%"><b>PCS Video Lectures</b><th></td><td align="right" width="30%" style="font-family: Calibri; color: white;">New to PCS Videos?</td><td width="30%" align="middle">   <button type="button" style=" border-color: #d14836; color: white; background-color: #d14836; font-family: Calibri;" onClick="window.location.href='Registration.jsp'">CREATE AN ACCOUNT</button></td></tr>        
    </table><br>
    <script language="javascript" type="text/javascript">

	function validate()
	{
		var uname=document.f1.user.value;
		var pass=document.f1.pwd.value;
		if(uname=="")
		{
			alert("Please Enter User Name");
			document.f1.user.focus();
			
			return false;
		}

		else if(pass=="")
		{
			alert("Please Enter password");
			document.f1.pwd.focus();
			
			return false;
		}
		
	}
</script>
</head>
<body bgcolor="#E6E6FA">
    <form name="f1" action="Login" method="get" onsubmit="return validate()" >
<right><table style="alignment-adjust: middle">
            <tr></tr> 
            <tr><td style="font-family: Calibri; font-size: 35px; color: #d14836; " width="70%"><th></td><td width="30%" style="font-family: Calibri; color: #333; font-size: 20px;">Sign in</td></tr>        
            <tr><td style="font-family: Calibri; font-size: 35px; color: #d14836; " width="70%"><th></td><td width="30%" style="font-family: Calibri; color: #333;"><br></td></tr>        
            <tr><td align="middle" style="font-family: Calibri; font-size: 20px; color: #333;" width="70%">Keep up with your favorite channels<th></td><td width="30%" style="font-family: Calibri; color: #333;"><b>Username</b></td></tr>
            <tr><td align="middle" width="70%"><p style="font-family: Calibri; font-size: 15px; color: #333;">Save videos to watch later, watch recommendations just for you, or subscribe to get updates from your favorite channels.</p><th></td><td><input type="text" name="user"></td></tr>
            <tr><td align="middle" style="font-family: Calibri; font-size: 20px; color: #333;" width="70%">Watch everywhere<th></td><td width="30%" style="font-family: Calibri; color: #333;"><b>Password</b></td></tr>
            <tr><td align="middle" width="70%"><p style="font-family: Calibri; font-size: 15px; color: #333;">Take your picks with you wherever you go — watch on your smartphone, tablet.</p><th></td><td><input type="password" name="pwd"></td></tr>
            <tr><td align="middle" style="font-family: Calibri; font-size: 20px; color: #333; " width="70%">Share with your friends<th></td><td><input type="submit" value="Submit" onClick="validate()" style=" border-color: #d14836; color: white; background-color: #d14836; font-family: Calibri;" ></td></tr>
            </form>

            <tr><td align="middle" width="70%"><p style="font-family: Calibri; font-size: 15px; color: #333;">See videos shared by your friends across all your social networks — all in one place.</p><th></td><td><a href="forgot.jsp" style="text-decoration: none; target: _top;">Can't access your account?</td></tr>
            <tr><td align="middle" style="font-family: Calibri; font-size: 35px; color: #d14836; " width="70%"><th></td><td></td></tr>
            <tr></tr>
    </table>
    <br></br><br></br><br></br>  <br></br><br><center>
        <table><tr><td><br></td></tr></table>
        <table style="background-color:  #1C1C1C;" ><tr><td style="font-family: Calibri; font-size: 15px; color: white;"><td width="20%" align="middle"><p style="font-family: Calibri; color: white;">© 2013 MSIT</p></td><td width="20%" align="middle" style="font-family: Calibri;color: white;"> <a href="terms.jsp"> Terms of Service</a></td><td width="20%" align="middle" style="font-family: Calibri;color: white;"> <a href="privacy.jsp">  Privacy Policy</a></td><td width="20%" align="middle" style="font-family: Calibri;color: white;"><a href="help.jsp"> Help</a><th></td><td width="20%" align="middle" style="font-family: Calibri; color: white;">English(United States)</td></tr>        
    </table>
</body>
</html>
 
