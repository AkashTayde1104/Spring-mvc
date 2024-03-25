<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function register()
{
	
	window.location.search;    <!-- all url data get or read using this line and pass to specific page...all hidden data pass to url -->
	document.myform.action="reg";
	document.myform.submit();
	alert("Registration Done Successfully")
}
</script>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body style= "background-color: lightyellow ">
<form name="myform">
<h1>
<marquee direction="left" style="color:blue">Welcome to XXX Bank</marquee></h1>
<h3>
<input type="button" value="Go back !" style="background-color: lightgreen" onclick="history.back()">
<pre>

<input type="hidden" name= "name" value="${name}">  <!-- form backend to frontend data come using modal interface keyword "name" use in page in expression laguage -->

Account Type        : <select name="acc_Type" required="required">
                       <option value="Savings">acc_Type</option>
                       <option value="Savings">Savings</option>
                       <option value="Current">Current</option>
                      </select>

Account Number      : <input type="text" name="a_Num" required="required"></pre>

First Name &nbsp; &emsp; &nbsp; &emsp; &nbsp; &emsp; &nbsp;&emsp; :&nbsp; &nbsp;   <input type="text" name="f_Name" required="required"> &nbsp; &nbsp; 

Middle Name         : <input type="text" name="m_Name" required="required">&nbsp; &nbsp; 

Last Name           : <input type="text" name="l_Name" required="required">
<br><br>
City/Village &nbsp; &emsp; &nbsp; &emsp; &nbsp; &emsp; &nbsp;&emsp; :&nbsp; &nbsp;   <input type="text" name="city" required="required">&nbsp; &nbsp; 

District            : <input type="text" name="district" required="required"> &nbsp; &nbsp; 

Pincode             : <input type="text" name="pincode" required="required"><pre>
Adhaar Number       : <input type="text" name="adhar_Num" required="required">

PAN Number          : <input type="text" name="pan_Num" required="required">

Birth Date          : <input type="date" name="birth_Date" min="1990-01-01" max="2025-12-31"  required="required">

Mobile Number       : <input type="text" name="a_Mob_No" required="required">

Enter Pin           : <input type="password" name="pin" required="required">

Deposit Money       : <input type="text" name="a_DepositMoney" required="required">

UserName            : <input type="text" name="user" required="required">

Password            : <input type="password" name="pass" required="required">

<input type="submit" value="Register" style="background-color: lightblue;" onclick="register()">

 <!-- onclick  register button it goes to function register() upside and all data of page is bind with particular action i.e name=myform and give some name ofor mapping i.e myform.action="reg" 
 at the time of myform.submit() this action goes to homecontroller and map request with specified method as /reg ...i.e onclick find /reg mapping in contrller and perform operation of backend.
 -->
 
</pre>
</h3>

</form>
</body>
</html>