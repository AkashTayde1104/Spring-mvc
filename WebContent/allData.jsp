<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.tech.model.Account" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function addData()
{
  alert("Do you want to add account?")
  window.location.search;//go hidden global feild through url to controller and pass to specified page
  document.myform.action="add_cust"; // go to admin controller
  document.myform.submit();
  
}

function deleteData()
{
	alert("Do you want to delete account?")
	window.location.search;
	document.myform.action="delete";
	document.myform.submit();
}

function updateData()
{ 
	alert("Do you want to update account?")
	 window.location.search;
	document.myform.action="edit";
	document.myform.submit();
}
function logout()
{
	document.myform.action="logout";
	document.myform.submit();
	}
</script>
<meta charset="ISO-8859-1">
<title>All Data</title>
</head>
<body  style="text-align: center;">
<form name="myform">

<input type="hidden" name= "name" value="${name}">

<table border=2 style="margin-left: auto;margin-right: auto ; background-color: lightblue;">

<tr bgcolor="pink">
<td>Select</td>
<td>AccNum</td>
<td>Name</td>
<td>Address</td>
<td>Adhar Num</td>
<td>PAN Num</td>
<td>MobNum</td>
<td>Birth-Date</td>
<td>DepositMoney</td>
<td>Pin</td>
<td>UserName</td>
<td>Pass</td>
</tr>

<tr>
<c:forEach items="${data}" var="acc">//<!-- iterate of all accouts list data directly on fronend -->
<td><input type="radio" name="rd" value="${acc.a_Num }"></td>
<td><c:out value="${acc.a_Num }"></c:out></td>
<td><c:out value="${acc.a_Name.f_Name} ${acc.a_Name.m_Name} ${acc.a_Name.l_Name}"></c:out></td>
<td><c:out value="${acc.a_Addrs.city} ${acc.a_Addrs.district} - ${acc.a_Addrs.pincode}"></c:out></td>
<td><c:out value="${acc.adhar_Num}"></c:out></td>
<td><c:out value="${acc.pan_Num}"></c:out></td>
<td><c:out value="${acc.a_Mob_No}"></c:out></td>
<td><c:out value="${acc.birth_Date}"></c:out></td>
<td><c:out value="${acc.a_DepositMoney}"></c:out></td>
<td><c:out value="${acc.pin}"></c:out></td>
<td><c:out value="${acc.user}"></c:out></td>
<td><c:out value="${acc.pass }"></c:out></td>
</tr>
</c:forEach>
</table>
<br>
<input type="button" value="ADD" style="background-color:lightyellow" onclick="addData()"><!-- go to function addData() at above -->
<input type="button" value="DELETE" style="background-color: lightbrown" onclick="deleteData()"> 
<input type="button" value="UPDATE" style="background-color: skyblue" onclick="updateData()">
<br>
<br>


 <input type="button" value="LOGOUT" style="background-color: red" onclick="logout()">
</form> 
</body>
</html>
