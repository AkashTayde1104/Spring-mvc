<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function balanceEnquiry()
{
	window.location.search;
	document.my_form.action="balance";
	document.my_form.submit();
}
</script>
<meta charset="ISO-8859-1">
<title>Balance Enquiry</title>
</head>
<body style="text-align:center; background-color: lightyellow">
<form name="my_form">
<input type="button" value="Go back !" style="background-color: lightgreen" onclick="history.back()">
<h1> Balance Enquiry  </h1>

<input type="hidden" name="a_Num" value="${a_Num}">
<input type="hidden" name="a_Name" value="${a_Name}">
<input type="hidden" name="a_DepositMoney" value="${amount}">

<h2>
<pre>

Pin   : <input type="password" name="pin">

<input type="button" value="Check Balance " onclick="balanceEnquiry()" >
</pre>
</h2>
</form>
</body>
</html>