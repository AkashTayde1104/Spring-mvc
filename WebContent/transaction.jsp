<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function transfer()
{
	window.location.search;
	document.myform.action="transfer";
	document.myform.submit();
}
</script>
<meta charset="ISO-8859-1">
<title>Deposit Money</title>
</head>
<body style="text-align:center ; background-color: lightyellow">
<form name="myform">
<pre>
<h2>
<input type="button" value="Go back !" style="background-color: lightgreen" onclick="history.back()">
<input type="hidden" name="account_No" value="${a_Num}">
<input type="hidden" name="acc_Type" value="${acc_Type}">
<input type="hidden" name="amt" value="${amount}">


Receiver Account Number       : <input type="text" name="a_Num"> 

Enter Money                   : <input type="text" name="a_DepositMoney">

Enter Pin                     : <input type="password" name="pin">

<input type="submit" value="Transfer" style="background-color:skyblue" onclick="transfer()">
</h2>
</pre>
</form>
</body>
</html>