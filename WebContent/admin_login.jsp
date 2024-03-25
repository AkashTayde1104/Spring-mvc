<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body style="text-align:center; background-color: lightyellow">
<form action="admin_log">
<h1>
<marquee direction="left" style="color:blue">Welcome to XXX Bank</marquee></h1>
<pre>
<input type="button" value="Go back !" style="background-color: lightgreen" onclick="history.back()">

<h2>
UserName       : <input type="text" name="user">

Password       : <input type="password" name="pass">
</h2>
<h3><input type="submit" value="Login" style="background-color:lightblue"><!--  go to dmin controller mapping  /admin_log -->


<span style="color:red">${msg}</span>
<!--  <input type="button" value="Create New Account" style="background-color: lightgreen" onclick="window.location.href="registration.jsp">-->
</h3>
</pre>
</form>
</body>
</html>