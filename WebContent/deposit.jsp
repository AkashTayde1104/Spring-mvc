<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function deposit()
{
	window.location.search;
	document.myform.action="deposit";
	document.myform.submit();
}
</script>
<meta charset="ISO-8859-1">
<title>Deposit Money</title>
</head>
<body style="text-align:center; background-color: lightyellow">
<form name="myform">
<pre>
<h2>
<input type="button" value="Go back !" style="background-color: lightgreen" onclick="history.back()">
<input type="hidden" name="account_No" value="${a_Num}">
<input type="hidden" name="acc_Type" value="${acc_Type}">
<input type="hidden" name="amt" value="${amount}">


Enter Money                   : <input type="text" name="a_DepositMoney">

Enter Pin                     : <input type="password" name="pin">

<input type="submit" value="Deposit" style="background-color:skyblue" onclick="deposit()">
</h2>
</pre>
</form>
</body>
</html>