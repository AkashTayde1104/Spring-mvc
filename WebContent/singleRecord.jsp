<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.tech.modal.Student" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Single Records</title>
</head>
<body style="text-align: center">


<table border=2 style="background:lightpink; margin-left: auto;margin-right: auto">
<tr bgcolor="skyblue">

<td>S_Id</td>
<td>S_Name</td>
<td>addrs</td>
<td>UserName</td>
<td>Password</td>
</tr>

<tr>
<c:forEach items="${data}" var="stu">

<td><c:out value="${stu.s_Id}"></c:out></td>
<td><c:out value="${stu.s_Name}"></c:out></td>
<td><c:out value="${stu.addrs}"></c:out></td>
<td><c:out value="${stu.user}"></c:out></td>
<td><c:out value="${stu.pass}"></c:out></td>

</tr>
</c:forEach>
</table>

</form>
</body>
</html>