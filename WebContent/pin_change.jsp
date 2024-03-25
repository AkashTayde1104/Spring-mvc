<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function pinChange()
{
	window.location.search;
	document.my_form.action="pin";
	document.my_form.submit();
}
</script>
<meta charset="ISO-8859-1">
<title>Pin Change</title>
</head>
<body  style="text-align: center ; background-color: lightyellow">
<form name="my_form">

<input type="button" value="Go back !" style="background-color: lightgreen" onclick="history.back()">

<input type="hidden" name="a_Num" value="${a_Num}">
<input type="hidden" name="a_Name" value="${a_Name}">
<input type="hidden" name="acc_Type" value="${acc_Type}">
<input type="hidden" name="a_DepositMoney" value="${amount}">
<h2>
<pre>
Old Pin       : <input type="password" name="old" >

New Pin       : <input type="password" name="new">

Confirm Pin   : <input type="password" name="confirm" placeholder="Confirm Pin">

<input type="button" Value="Change Pin" style="background-color: lightblue" onclick="pinChange()">
</pre>

</h2>


</form>
</body>
</html>