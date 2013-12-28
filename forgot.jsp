<%-- 
    Document   : forgot
    Created on : Sep 5, 2013, 12:33:59 AM
    Author     : SivaRamaKrishnamRaju
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 
<script language="javascript" type="text/javascript">

	function validate()
	{
		var reg1 = /^[A-Za-z]+.*[0-9,+-_&#@]+.*/;
		var reg2=/^[a-zA-Z0-9_]*$/;
		var reg3=/^[a-zA-Z]*$/
		var regmail=/^[a-zA-Z0-9._-]+@[a-zA-Z]+\.[a-zA-Z]{2,6}$/;
		var regadd=/^[A-Za-z][A-Za-z0-9, .-_/]+$/;

		var uname=document.f1.user.value;
		var que=document.f1.que.value;
		var ans=document.f1.ans.value;

		if(uname=="")
		{
			alert("Please Enter User Name");
			document.f1.user.focus();
			
			return false;
		}

		else if((!uname.match(reg1))||uname.match(" "))
		{
			alert("Enter a valid user name");
			document.f1.user.focus();
			
			return false;
		}
		else if(que==0 || ans=="")
		{
			alert("enter valid answer to the question");
			document.f1.ans.focus();
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
<form name="f1" action="Forgotpswd" method="get" onsubmit="return validate()" >
 
<tr>
<table align="left">
<tr>
<td >Login Name :</td>
<td><input type="text" name="user"></td>
</tr>
<tr>
<td >Secret Question :</td>
<td ><select name="que">
<option value="0">QUESTIONS</option>
<option value="YOUR FAVORITE COLOR?">YOUR FAVORITE COLOR?</option>
<option value="YOUR FAVORITE GAME?">YOUR SURNAME?</option>
<option value="YOUR LIKING PERSON?">YOUR FIRST MOBILE NUMBER?</option>
<option value="YOUR LOOK LIKE?">YOUR FAVORITE GAME?</option>
</td>
</tr>
<tr>
<td >Answer :</td>
<td><input type="text" name="ans"></td>
</tr>
<td ><input type="submit" value="submit" onClick="validate()"></td>
</body>
</html>
