<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.tech.model.Account" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function addData()
{
  alert("Do you want to add account?")
  document.myform.action="admin_register.jsp";
  document.myform.submit();
  
}

function deleteData()
{
	alert("Do you want to delete account?")
	document.myform.action="delete";
	document.myform.submit();
}

function updateData()
{ 
	alert("Do you want to update account?")
	document.myform.action="edit";
	document.myform.submit();
}
function logout()
{
	document.myform.action="index.jsp";
	document.myform.submit();
	}
</script>
<meta charset="ISO-8859-1">
<title>History</title>
</head>
<body  style="text-align: center;">
<form name="myform">
<table border=2 style="margin-left: auto;margin-right: auto ; background-color: lightblue;">

<tr bgcolor="pink">
<td>Id</td>
<td>AccNum</td>
<td>Transaction Type</td>
<td>Amount</td>
<td>Date</td>

</tr>

<tr>
<c:forEach items="${data}" var="acc">
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
<input type="button" value="ADD" style="background-color:lightyellow" onclick="addData()">
<input type="button" value="DELETE" style="background-color: lightbrown" onclick="deleteData()"> 
<input type="button" value="UPDATE" style="background-color: skyblue" onclick="updateData()">
<br>
<br>


 <input type="button" value="LOGOUT" style="background-color: red" onclick="logout()">
</form> 
</body>
</html>
