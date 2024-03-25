<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function update()
{
	window.location.search;
	document.myform.action="update";
	document.myform.submit();
	}</script>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body style="text-align: center">
<form name="myform">
<pre>
<h2>
<input type="button" value="Go back !" style="background-color: lightgreen" onclick="history.back()">

<input type="hidden" name= "name" value="${name}">

Account Num          :  <input type="hidden" name="a_Num" value="${data.a_Num}">

<!--  Account Holder Name  :  <input type="text" name="a_Name" value="${data.a_Name} ${data.a_Name.m_Name} ${data.a_Name.l_Name}" >

Address              :  <input type="text" name="a_Addrs" value="${data.a_Addrs} ${acc.a_Addrs.district} - ${acc.a_Addrs.pincode}">
-->
First Name           :  <input type="text" name="f_Name" value="${data.a_Name.f_Name} " >

Middle Name          :  <input type="text" name="m_Name" value="${data.a_Name.m_Name} " >

Last Name            :  <input type="text" name="l_Name" value="${data.a_Name.l_Name}">

City/Village         :  <input type="text" name="city" value="${data.a_Addrs.city} ">

District             :  <input type="text" name="district" value="${data.a_Addrs.district}">

Pincode              :  <input type="text" name="pincode" value="${data.a_Addrs.pincode}">

Adhaar Number        :  <input type="text" name="adhar_Num" value="${data.adhar_Num}">

PAN Number           :  <input type="text" name="pan_Num" value="${data.pan_Num}">

Mobile Num           :  <input type="text" name="a_Mob_No" value="${data.a_Mob_No}">

Birth-Date           :  <input type="text" name="birth_Date" value="${data.birth_Date}">

Deposit Money        :  <input type="text" name="a_DepositMoney" value="${data.a_DepositMoney}">

Pin                  :  <input type="text"  name="pin" value="${data.pin}">

UserName             :  <input type="text" name="user" value="${data.user}">

Password             :  <input type="text" name="pass" value="${data.pass}">

<input type="submit" value="Update" style="text-align:center; background-color:lightblue" onclick="update()">

</h2>
</pre>
</form>
</body>
</html>