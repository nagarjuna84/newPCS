<%-- 
    Document   : changepwd
    Created on : Mar 13, 2013, 11:22:46 PM
    Author     : Nagarjun Reddy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Forgot Password</title>
<script language="javascript" type="text/javascript">

	function validate()
	{
		var reg1 = /^[A-Za-z]+.*[0-9,+-_&#@]+.*/;
		var reg2=/^[a-zA-Z0-9_]*$/;
		var reg3=/^[a-zA-Z]*$/
		var regmail=/^[a-zA-Z0-9._-]+@[a-zA-Z]+\.[a-zA-Z]{2,6}$/;
		var regadd=/^[A-Za-z][A-Za-z0-9, .-_/]+$/;

		var pass=document.f1.pwd.value;
		var rpass=document.f1.rpwd.value;

		if(pass=="")
		{
			alert("Please Enter password");
			document.f1.pwd.focus();
			
			return false;
		}
		else if(!pass.match(reg2))
		{
			alert("Enter a valid password");
			document.f1.pwd.focus();
			return false;
		}
		else if(pass.length<5 || pass.length>10)
		{
			alert("password length should be in between 5-10");
			document.f1.pwd.focus();
			return false;
		}
		else if(rpass=="")
		{
			alert("Please Enter Re Enter Password");
			document.f1.rpwd.focus();
			return false;
		}
		else if(rpass.length<5 || rpass.length>10)
		{
			alert("Re-password length should be in between 5-10");
			document.f1.rpwd.focus();
			return false;
		}
		else if(rpass!=pass)
		{
			alert("Password donot match");
			document.f1.rpwd.focus();
			return false;
		}

	}
</script>
</head>
<body bgcolor="#E6E6FA">
    <table style="background-color: black">
        <tr></tr> 
        <tr><td style="font-family: Calibri; font-size: 35px; color: #d14836; " width="80%"><b>PCS Video Lectures</b><th></td><td width="20%"><button type="button" style=" border-color: #d14836; color: white; background-color: #d14836; font-family: Calibri;" onClick="window.location.href='index.jsp'">Sign In</button></td></tr>        
    </table><br>
<form name="f1" action="Changepwd" method="get" onsubmit="return validate()" >
<h1 align="center" style="font-family:algerian;">Forgot Password</h1>
<tr>
<table align="center"  width="50%">
<tr>
<td>Enter New Password:</td>
<td><input type="password" name="pwd"></td>
</tr>
<tr>
<td>Re-Enter password :</td>
<td><input type="password" name="rpwd"></td>
</tr>
<td><input type="submit" value="submit" onClick="validate()"></td>
</body>
</html>
