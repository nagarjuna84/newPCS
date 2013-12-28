<%-- 
    Document   : Registration
    Created on : Sep 5, 2013, 12:13:03 AM
    Author     : SivaRamaKrishnamRaju
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<body bgcolor="#E6E6FA"><br>
    <table style="background-color: black">
        <tr></tr> 
        <tr><td align="middle"style="font-family: Calibri; font-size: 35px; color: #d14836; " width="80%"><b>PCS Video Lectures</b><th></td><td width="20%"><button type="button" style=" border-color: #d14836; color: white; background-color: #d14836; font-family: Calibri;" onClick="window.location.href='index.jsp'">Sign In</button></td></tr>        
    </table><br>

<LINK href="style1.css" rel="stylesheet" type="text/css">
<script language="javascript" type="text/javascript">

	function validate()
	{
		var reg1 = /^[A-Za-z]+.*[0-9,+-_&#@]+.*/;
		var reg2=/^[a-zA-Z0-9_]*$/;
		var reg3=/^[a-zA-Z]*$/
		var regmail=/^[a-zA-Z0-9._-]+@[a-zA-Z]+\.[a-zA-Z]{2,6}$/;
		var regadd=/^[A-Za-z][A-Za-z0-9, .-_/]+$/;

		var uname=document.f1.user.value;
		var fname=document.f1.fname.value;
		var lname=document.f1.lname.value;
		var pass=document.f1.pwd.value;
		var rpass=document.f1.rpwd.value;
		var year=document.f1.year.value;
		var mnth=document.f1.month.value;
		var day=document.f1.day.value;
		var checked = false;
		var buttons = document.f1.gen;
		var mail=document.f1.mail.value;
		var add=document.f1.add.value;
		var que=document.f1.que.value;
		var ans=document.f1.ans.value;

		if(fname=="")
		{
			alert("Please Enter First Name");
			document.f1.fname.focus();
			return false;
		}

		else if(!fname.match(reg3)||fname.match(" "))
		{
			alert("Enter a valid First Name");
			document.f1.fname.focus();
			
			return false;
		}
		else if(fname.length<5 || fname.length>20)
		{
			alert("First Name length should be in between 5-20");
			document.f1.fname.focus();
			
			return false;
		}
		
		else if(lname=="")
		{
			alert("Please Enter Last Name");
			document.f1.lname.focus();
			
			return false;
		}

		else if(!lname.match(reg3)||lname.match(" "))
		{
			alert("Enter a valid Last Name");
			document.f1.lname.focus();
			
			return false;
		}
		else if(lname.length<5 || lname.length>20)
		{
			alert("Last Name length should be in between 5-20");
			document.f1.lname.focus();
			
			return false;
		}

		else if(uname=="")
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

		else if(year=="0")
		{
			alert("Enter valid date of birth");
			document.f1.year.focus();
			
			return false;
		}
		else if(mnth=="0")
		{
			alert("Enter valid date of birth");
			document.f1.month.focus();
			
			return false;
		}
		else if(day=="0")
		{
			alert("Enter valid date of birth");
			document.f1.day.focus();
			
			return false;
		}

		for (var i=0; i<buttons.length; i++) 
		{ 
			if (buttons[i].checked) 
			{ 
				checked = true;
				break; 
			} 
		}
		if(!checked)
		{
			alert("you have to choose a Gender");
			return false;
		}
		else if(mail==""||mail==" ")
		{
			alert("Please Enter e - mail ID");
			return false;
		}
		else if(!mail.match(regmail))
		{
			alert("Enter a valid e - mail ID");
			return false;
		}
		else if(pass=="")
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
		else if(add=="")
		{
			alert("Please Enter Address");
			document.f1.add.focus();
			return false;
		}
		else if(!add.match(regadd))
		{
			alert("Please Enter Valid Address");
			document.f1.add.focus();
			return false;
		}

		else if(que!=0 && ans=="")
		{
			alert("enter valid answer to the question");
			document.f1.ans.focus();
			return false;
		}

	}
</script>
</head>
<br></br> 
<form name="f1" action="Registration" method="get" onsubmit="return validate()" >
    <table align ="left"><tr><td style="font-family: Calibri; font-size: 35px; color: #d14836;">Create a new PCS Account</td></tr></table>
<table align="right">
<tr>
<td style="font-family: Calibri; color: #333;">First Name :</td>
<td><input type="text" name="fname"></td>
</tr>
<tr>
<td style="font-family: Calibri; color: #333;">Last Name :</td>
<td><input type="text" name="lname"></td>
</tr>
<tr>
<td style="font-family: Calibri; color: #333;">Login Name :</td>
<td><input type="text" name="user"></td>
</tr>
<tr>
<td style="font-family: Calibri; color: #333;">Date of Birth :</td>
<td><select name="month">
<option value="0">Month</option>
<option value="1">January</option>
<option value="2">February</option>
<option value="3">March</option>
<option value="4">April</option>
<option value="5">May</option>
<option value="6">June</option>
<option value="7">July</option>
<option value="8">August</option>
<option value="9">September</option>
<option value="10">October</option>
<option value="11">November</option>
<option value="12">December</option>
</select>

<select name="day">
<option value="0">Day</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
<option value="7">7</option>
<option value="8">8</option>
<option value="9">9</option>
<option value="10">10</option>
<option value="11">11</option>
<option value="12">12</option>
<option value="13">13</option>
<option value="14">14</option>
<option value="15">15</option>
<option value="16">16</option>
<option value="17">17</option>
<option value="18">18</option>
<option value="19">19</option>
<option value="20">20</option>
<option value="21">21</option>
<option value="22">22</option>
<option value="23">23</option>
<option value="24">24</option>
<option value="25">25</option>
<option value="26">26</option>
<option value="27">27</option>
<option value="28">28</option>
<option value="29">29</option>
<option value="30">30</option>
<option value="31">31</option>
</select>

<select name="year">
<option value="0">Year</option>
<option value="2008">2008</option>
<option value="2007">2007</option>
<option value="2006">2006</option>
<option value="2005">2005</option>
<option value="2004">2004</option>
<option value="2003">2003</option>
<option value="2002">2002</option>
<option value="2001">2001</option>
<option value="2000">2000</option>
<option value="1999">1999</option>
<option value="1998">1998</option>
<option value="1997">1997</option>
<option value="1996">1996</option>
<option value="1995">1995</option>
<option value="1994">1994</option>
<option value="1993">1993</option>
<option value="1992">1992</option>
<option value="1991">1991</option>
<option value="1990">1990</option>
<option value="1989">1989</option>
<option value="1988">1988</option>
<option value="1987">1987</option>
<option value="1986">1986</option>
<option value="1985">1985</option>
<option value="1984">1984</option>
<option value="1983">1983</option>
<option value="1982">1982</option>
<option value="1981">1981</option>
<option value="1980">1980</option>
<option value="1990">1979</option>
<option value="1989">1978</option>
<option value="1988">1977</option>
<option value="1987">1976</option>
<option value="1986">1975</option>
<option value="1985">1974</option>
<option value="1984">1973</option>
<option value="1983">1972</option>
<option value="1982">1971</option>
<option value="1982">1970</option>
<option value="1990">1969</option>
<option value="1989">1968</option>
<option value="1988">1967</option>
<option value="1987">1966</option>
<option value="1986">1965</option>
<option value="1985">1964</option>
<option value="1984">1963</option>
<option value="1983">1962</option>
<option value="1982">1961</option>
<option value="1981">1960</option>
<option value="1990">1959</option>
<option value="1989">1958</option>
<option value="1988">1957</option>
<option value="1987">1956</option>
<option value="1986">1955</option>
<option value="1985">1954</option>
<option value="1984">1953</option>
<option value="1983">1952</option>
<option value="1982">1951</option>
<option value="1981">1950</option>

</select>

</td>
</tr>

<tr>
<td style="font-family: Calibri; color: #333;">Gender:</td>
<td><input type="radio" value="m" name="gen">Male<input type="radio" value="f" name="gen">Female</td>
</tr>

<tr>
<td style="font-family: Calibri; color: #333;">E-Mail ID :</td>
<td><input type="text" name="mail"></td>
</tr>

<tr>
<td style="font-family: Calibri; color: #333;">Password :</td>
<td><input type="password" name="pwd"></td>
</tr>

<tr>
<td style="font-family: Calibri; color: #333;">Retype Password :</td>
<td><input type="password" name="rpwd"></td>
</tr>

<tr>
<td style="font-family: Calibri; color: #333;">Address :</td>
<td><textarea rows="7" cols="25" name="add"></textarea></td>
</tr>
<tr>
<td style="font-family: Calibri; color: #333;">Secret Question :</td>
<td><select name="que">
<option value="0">QUESTIONS</option>
<option value="YOUR FAVORITE COLOR?">YOUR FAVORITE COLOR?</option>
<option value="YOUR FAVORITE GAME?">YOUR SURNAME?</option>
<option value="YOUR LIKING PERSON?">YOUR FIRST MOBILE NUMBER?</option>
<option value="YOUR LOOK LIKE?">YOUR FAVORITE GAME?</option>
</td>
</tr>
<tr>
<td style="font-family: Calibri; color: #333;">Answer :</td>
<td><input type="text" name="ans"></td>
</tr>
<tr>
<td style="font-family: Calibri; color: #333;">Alternate E-Mail ID :</td>
<td><input type="text" name="amail"></td>
</tr>
<tr>

<td style="font-family: Calibri; color: #333;"><input type="submit" value="submit" onClick="validate()"></td>
</tr>

</table>

</form>



</body>
</html>
