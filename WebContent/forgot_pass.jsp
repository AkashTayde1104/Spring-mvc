<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forget Pass</title>
</head>
<body style="text-align: center">
<form action="forget">
<h2>
<input type="button" value="Go back !" style="background-color: lightgreen" onclick="history.back()"><!-- go to back page button -->
<pre>
Enter Account Number : <input type="text" name="accNum">

Enter new Password   : <input type="password" name="pass">

Confirm Password     : <input type="password" name="new_pass">

<input type="submit" value="change Password"><!-- onclick action goes to controller method with specified mapping /forget -->
</pre>
</h2>
</form>
</body>
</html>