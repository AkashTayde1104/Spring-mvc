<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.tech.modal.Student" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function deletedata()
{
   alert("Do you want to delete record?")
   document.myform.action="delete";
   document.myform.submit();
}

function addData()
{
   alert("Do you want to add record?")
  // window.location.href="register.jsp";
   document.myform.action="register.jsp";
   document.myform.submit();
}
function updateData()
{
   alert("Do you want to update record?")
   document.myform.action="edit";
   document.myform.submit();
}
function logoutData()
{
   alert("Do you want to logout?")
   //document.myform.action="index.jsp";
  // document.myform.submit();
  // window.preventBackButton();
   Response.Redirect("index.jsp");
   
}
</script>
<meta charset="ISO-8859-1">
<title>Student Records</title>
</head>
<body style="text-align: center">
<form name="myform">

<table border=2 style="background:lightpink; margin-left: auto;margin-right: auto">
<tr bgcolor="skyblue">
<td>Select</td>
<td>S_Id</td>
<td>S_Name</td>
<td>addrs</td>
<td>UserName</td>
<td>Password</td>
</tr>

<tr>
<c:forEach items="${data}" var="stu">
<td><input type="radio" name="rd" value="${stu.s_Id}"></td>
<td><c:out value="${stu.s_Id}"></c:out></td>
<td><c:out value="${stu.s_Name}"></c:out></td>
<td><c:out value="${stu.addrs}"></c:out></td>
<td><c:out value="${stu.user}"></c:out></td>
<td><c:out value="${stu.pass}"></c:out></td>

</tr>
</c:forEach>
</table>

<input type="button" value="Add" style="background-color: pink" onclick="addData()">
<input type="button" value="Update" style="background-color: lightgreen" onclick="updateData()">
<input type="button" value="Delete" style="background-color: skyblue" onclick="deletedata()"><br>
<!--  <input type="button" value="Logout" style="background-color: red" onclick="logoutData()">-->
<p><a href="index.jsp" target="self"><font color="red"><b>Logout</b></font></a></p>
</form>
</body>
</html>