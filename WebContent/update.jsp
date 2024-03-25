<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student</title>
</head>
<body style="text-align:center ; background-color:lightyellow">
<form action="update"  >
<pre>
<h2>

Student Id  :  <input type="hidden" name="s_Id" value="${data.s_Id}">

Student Name    :  <input type="text" name="s_Name" value="${data.s_Name}"> 

Student Address :  <input type="text" name="addrs" value="${data.addrs}">

UserName        :  <input type="text" name="user" value="${data.user}">

Password        :  <input type="text" name="pass" value="${data.pass}">

<input type="submit" value="Update" style="text-align:center; background-color:lightblue">
</h2>
</pre>
</form>
</body>
</html>