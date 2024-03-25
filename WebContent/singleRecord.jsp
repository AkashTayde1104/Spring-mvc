<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.tech.model.Account" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Single Data</title>
</head>
<body  style="text-align: center; background-color: lightyellow">

<input type="button" value="Go back !" style="background-color: lightgreen" onclick="history.back()">
<input type="hidden" name="a_Name" value="${a_Name}">
<input type="hidden" name="a_Addrs" value="${a_addrs}">



<pre>
<h1>
Account Num          :  <input type="text" name="a_Num" value="${data.a_Num}" readonly="readonly">

Account Holder Name  :  <input type="text" name="a_Name" value="${a_Name}" readonly="readonly" >

Address              :  <input type="text" name="a_Addrs" value="${a_Addrs}" readonly="readonly">

Adhaar Number        :  <input type="text" name="adhar_Num" value="${data.adhar_Num}" readonly="readonly">

PAN Number           :  <input type="text" name="pan_Num" value="${data.pan_Num}" readonly="readonly">

Birth-Date           :  <input type="text" name="birth_Date" value="${data.birth_Date}" readonly="readonly">

Mobile Num           :  <input type="text" name="a_Mob_No" value="${data.a_Mob_No}" readonly="readonly">

UserName             :  <input type="text" name="user" value="${data.user}" readonly="readonly">

<!--  Password             :  <input type="text" name="pass" value="${data.pass}">-->


</h1>
</pre>
</form>
</body>
</html>